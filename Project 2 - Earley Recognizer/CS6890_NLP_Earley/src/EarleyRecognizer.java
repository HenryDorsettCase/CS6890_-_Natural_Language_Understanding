import java.util.*;
import java.io.*;

public class EarleyRecognizer 
{	
    Hashtable<String, String> partsOfSpeech;
    List<Rule> rules;
    List<String> ruleStrings;
    List<String> variableSymbols;
    List<String> terminalSymbols;
    List<String> startingSymbols;
    List<String> words;
    ArrayList<ArrayList<DottedRule>> chart;


    public EarleyRecognizer(int sizeOfChart)
    {
        words = new ArrayList<String>();
        partsOfSpeech = new Hashtable<String, String>();
        rules = new ArrayList<Rule>();
        ruleStrings = new ArrayList<String>();
        startingSymbols = new ArrayList<String>();
        variableSymbols = new ArrayList<String>();
        terminalSymbols = new ArrayList<String>();

        chart = new ArrayList<ArrayList<DottedRule>>();
        for(int entry = 0; entry < sizeOfChart; entry++)
            chart.add(new ArrayList<DottedRule>());
    }

    //Primarily the Earley Recognizer
    public static void main (String [] args)
    {
        if(args.length == 0)
        {
               System.out.println("cmd line args: <nameOfGrammarFile> <String to recognize>");
               System.exit(0);
        }
        //Creates chart and lists
        EarleyRecognizer er = new EarleyRecognizer(args.length);
        er.loadListsAndInputString(args);

        //The Earley Recognizer...
        er.enqueue(er.makeDummyRule(), er.chart.get(0));//prime the chart
        for (int i = 0; i <= er.words.size(); i++)
        {
            ArrayList<DottedRule> chartEntry = er.chart.get(i);
            for (int index = 0; index < chartEntry.size(); index++)
            {
                DottedRule currDR = chartEntry.get(index);
                //Run the predictor, scanner, and completer until
                //no more new states can be added to the chart.
                if(!currDR.isComplete() && !er.partsOfSpeech.contains(currDR.nextV()))
                    er.predictor(currDR);
                else if(!currDR.isComplete() && er.partsOfSpeech.contains(currDR.nextV()))
                    er.scanner(currDR);
                else
                    er.completer(currDR, i);
            }// for end
        }// for end

        //Print the final chart
        er.printChart();
        er.checkAndPrintIfStringIsInG();

    }//end method main

    // state is a dotted rule. chartEntry is chart[x].
    public void enqueue(DottedRule state, ArrayList<DottedRule> chartEntry)
    {
        if (!chartEntry.contains(state))
            chartEntry.add(state);
    }

    //For each completed rule B->?*, [j, k]), [j, k]
    //for each DottedRule in chart A->a*B, [i, j] in chart[j]
    public void completer(DottedRule completedDottedRule, int i)
    {
        ArrayList<DottedRule> j = chart.get(completedDottedRule.start);
        ArrayList<DottedRule> k = chart.get(completedDottedRule.end);
        for(DottedRule index : j)
        {
            if(index.dot != index.rule.rhs.size())
            {
                if(index.nextV().equals(completedDottedRule.rule.lhs) && index.end == completedDottedRule.start)
                {
                    DottedRule advancedDot = new DottedRule(index.rule, index.dot + 1, index.start, i);
                    enqueue(advancedDot, k);//(A->aB*�, [i, k]), chart[k]
                    //System.out.println("completer adds: " + advancedDot);
                }
            }
        }
    }

    //(A->a*B�, [i, j]). words is the input array.
    public void scanner(DottedRule dR)
    {
        if(dR.end != words.size())
        {
            if(dR.nextV().equals(partsOfSpeech.get(words.get(dR.end))))
            {
                for (Rule r: rules)
                {
                    if(r.isTheRightLexicalRule(dR.nextV(), words.get(dR.end)))
                    {
                        DottedRule temp = new DottedRule(r, 1, dR.end, dR.end + 1);
                        enqueue(temp, chart.get(dR.end + 1));
                        //System.out.println("scanner adds: " + temp);
                    }
                }
            }
        }
    }

    public void predictor(DottedRule dR)
    {
        for(Rule i: rules)//rules is the grammar
        {
            if (i.lhs.equals(dR.nextV()))
            {
                if(!terminalSymbols.contains(i.rhs.get(0)))
                {
                    DottedRule temp = new DottedRule(i, 0, dR.end, dR.end);
                    enqueue(temp, chart.get(dR.end));
                    //System.out.println("predictor adds: " + temp);
                }
            }
        }
    }
    
    public void checkAndPrintIfStringIsInG()
    {
        //Print if input string is in language
        boolean isStringInG = false;
        int lastIndexOfChart = chart.size()-1;
        for (DottedRule i: chart.get(lastIndexOfChart))
        {
            if(i.end == lastIndexOfChart && i.rule.lhs.equals("lambda"))
                isStringInG = true;
        }

        if(isStringInG)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //Load dummy rule
    public DottedRule makeDummyRule()
    {
        Rule temp = new Rule();
        temp.lhs = "lambda";
        temp.rhs.add(startingSymbols.get(0));//Should only ever be one starting symbol

        return new DottedRule(temp, 0,0,0);
    }

    public void loadListsAndInputString(String [] args)
    {
        loadFromFile_theLists_ruleS_variableS_terminalS_startingS(args[0]);
        loadRulesList();
        loadPartsOfSpeechHashtable();//key = terminal on RHS, value = variable on LHS,

        for(int i = 1; i < args.length; i++)//Loads "words" of input string
        {
            String temp = args[i];

            if(i == 1 && Character.isUpperCase(temp.charAt(0)))//if input string start with a capital letter
            {
                char first = temp.charAt(0);
                first = Character.toLowerCase(first);
                temp = Character.toString(first) + temp.substring(1, temp.length());
            }
            
            if(temp.endsWith(".") && (i == args.length -1))//last word has period
                temp = temp.substring(0, temp.length() - 1);
            
            words.add(temp);
        }
        System.out.println("words: " + words.toString());
        System.out.println();
    }

    public void loadFromFile_theLists_ruleS_variableS_terminalS_startingS(String nameOfFile)
    {
        List<String> fromFile = null;

        try
        {
            BufferedReader in = new BufferedReader(new FileReader(nameOfFile));
            while(in.ready())
            {
                String text = in.readLine();

                if(text.equals("<S>"))
                {
                    fromFile = startingSymbols;
                    text = in.readLine();
                }

                if(text.equals("<V>"))
                {
                    fromFile = variableSymbols;
                    text = in.readLine();
                }

                if(text.equals("<T>"))
                {
                    fromFile = terminalSymbols;
                    text = in.readLine();
                }

                if(text.equals("<P>"))
                {
                    fromFile = ruleStrings;
                    text = in.readLine();
                }

                while(!text.equals("</S>") && !text.equals("</V>") && !text.equals("</T>") && !text.equals("</P>"))
                {
                    fromFile.add(text);
                    text = in.readLine();
                }
            }

            in.close();
        }catch(Exception e){}

        System.out.println("startingSymbols: " + startingSymbols.toString());
        System.out.println("variableSymbols: " + variableSymbols.toString());
        System.out.println("terminalSymbols: " + terminalSymbols.toString());
        System.out.println("ruleStrings: " + ruleStrings.toString());
    }//end method loadFromFile_theLists_ruleS_variableS_terminalS_startingS()

    public void loadRulesList()
    {
        for (String i : ruleStrings)
        {
            Rule tempRule = new Rule();
            StringTokenizer tokenizer = new StringTokenizer(i," ");

            int index = 0;
            while (tokenizer.hasMoreTokens())
            {
                String temp = tokenizer.nextToken();
                if(index == 0)
                    tempRule.lhs = temp;
                else
                {
                    if(!temp.equals("::="))
                        tempRule.rhs.add(temp);
                }
                index++;
            }
            rules.add(tempRule);
        }
        System.out.println("rules: " + rules.toString());
    }//end method loadRulesList()

    public void loadPartsOfSpeechHashtable()
    {
        for(Rule i: rules)
        {
            if(i.rhs.size() == 1)
            {
                String temp = i.rhs.get(0);
                if(terminalSymbols.contains(temp))
                    partsOfSpeech.put(temp, i.lhs);
            }
        }
        System.out.println("PartsOfSpeech: " + partsOfSpeech.toString());
    }//end method loadPartsOfSpeechHashtable()

    public void printChart()
    {
        System.out.println("Chart->");

        int chartEntry = 0;
        for (ArrayList<DottedRule> i : chart)
        {
            System.out.println(chartEntry + " START*********************************");
            for (DottedRule r: i)
                System.out.println(r);
            System.out.println(chartEntry++ + " END***********************************");
        }
    }
}//end class EarleyRecognizer
	