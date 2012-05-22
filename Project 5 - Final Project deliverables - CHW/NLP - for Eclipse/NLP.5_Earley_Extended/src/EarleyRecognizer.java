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
    List<String> epsilonSymbols;
    List<String> epsilonProductionVariables;
    
    String [] argsCLA;
    List<String> words;
    
    int size;
    ArrayList<ArrayList<DottedRule>> chart;
    
    static boolean debug;

    public EarleyRecognizer(String [] args)
    {
    	debug = false;
    	
    	argsCLA = args;
    	if(args.length == 0)
    	{
	        System.out.println("cmd line args: <nameOfGrammarFile> <String to recognize>");
	        System.exit(0);
	    }
    	
        words 						= new ArrayList<String>();
        partsOfSpeech 				= new Hashtable<String, String>();
        rules 						= new ArrayList<Rule>();
        ruleStrings 				= new ArrayList<String>();
        startingSymbols 			= new ArrayList<String>();
        epsilonSymbols 				= new ArrayList<String>();
        variableSymbols 			= new ArrayList<String>();
        terminalSymbols 			= new ArrayList<String>();
        epsilonProductionVariables 	= new ArrayList<String>();
        
        int chartSize = loadListsAndInputString();

        chart = new ArrayList<ArrayList<DottedRule>>();
        for(int entry = 0; entry < chartSize; entry++)
            chart.add(new ArrayList<DottedRule>());
                
        enqueue(makeLambaToStartRule(), chart.get(0));//prime the chart
    }

    //Primarily the Earley Recognizer
    public static void main (String [] args)
    {    
        if(debug) System.out.println("START DEBUG->");

        //The Earley Recognizer...
        EarleyRecognizer er = new EarleyRecognizer(args); //Creates chart and lists
        for (int i = 0; i <= er.words.size(); i++)
        {
        	if(debug) System.out.println(" " + i + " START*********************************");
        	
            ArrayList<DottedRule> chartEntry = er.chart.get(i);
            for (int index = 0; index < chartEntry.size(); index++)
            {
                DottedRule currDR = chartEntry.get(index);

                //Run the predictor, scanner, and completer until no more new states can be added to the chart.
                if(!currDR.isComplete() && !er.partsOfSpeech.contains(currDR.nextV()))
                	try { er.predictor(currDR); } catch (Exception e) {} //catches concurrentModificationException, continues.
                else if(!currDR.isComplete() && er.partsOfSpeech.contains(currDR.nextV()))
                    er.scanner(currDR);
                else
                	try { er.completer(currDR, i); } catch (Exception e) {} //catches concurrentModificationException, continues.
            }
            if(debug) System.out.println(" " + i + " END*********************************");
        }
        if(debug) System.out.println("<-END DEBUG\n");

        er.printChart(); //Print the final chart  
        er.checkAndPrintIfStringIsInG(); //Print result: is string in grammar and, if true, the parse tree
    }//end method main

    // state is a dotted rule. chartEntry is chart[x].
    public void enqueue(DottedRule state, ArrayList<DottedRule> chartEntry)
    {
        if (!chartEntry.contains(state))
            chartEntry.add(state);
    }

    public void epsilonProductionHandler(DottedRule dR)
    {
    	DottedRule temp = new DottedRule(dR.rule, dR.dot+1, dR.start, dR.end);
    	enqueue(temp, chart.get(dR.end));

    	temp.children.addAll(dR.children);
    	temp.children.add(new DottedRule(Rule.makeEpsilonRule(dR.nextV()), 0, 0, 0));
    	
    	if(debug)  System.out.println("    epsilonHandler adds: " + temp);
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
                    
                    advancedDot.children.addAll(index.children);
                    advancedDot.children.add(completedDottedRule);
                    
                    if(debug) System.out.println("    completer adds:\t " + advancedDot);
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
                        
                        if(debug) System.out.println("    scanner adds:\t " + temp);
                    }
                }
            }
        }
    }

    public void predictor(DottedRule dR)
    {
        for(Rule i: rules)//rules is the grammar
        {        	
            if(i.lhs.equals(dR.nextV()))
            {
                if(!terminalSymbols.contains(i.rhs.get(0)))
                {
                    DottedRule temp = new DottedRule(i, 0, dR.end, dR.end);
                    enqueue(temp, chart.get(dR.end));
                    
                    if(debug) System.out.println("    predictor adds:\t " + temp);
                }
            }
        }
        
        if(!dR.isComplete() && epsilonProductionVariables.contains(dR.nextV()))
             epsilonProductionHandler(dR);
    }
    
    public void checkAndPrintIfStringIsInG()
    {
    	System.out.println("\nRESULTS->");
    	System.out.println("  inputString:\t\t" + argsCLA[1]);
    	System.out.println("  inputStringTokenized:\t" + words.toString());
        boolean isStringInG = false;
        int lastIndexOfChart = chart.size()-1;
        for (DottedRule i: chart.get(lastIndexOfChart))
        {
            if(i.end == lastIndexOfChart && i.rule.lhs.equals("lambda") && i.isComplete())
            {
                isStringInG = true;
                System.out.println("  STRING IN GRAMMAR->   true");
                System.out.println("  PARSE TREE->");
                prettyPrintParseTree(i, "\t");
            }
        }
        
        if(!isStringInG) System.out.println("  STRING IN GRAMMAR->   false");
        System.out.println("<-END RESULTS");
    }
    
    private void prettyPrintParseTree(DottedRule r, String spacer)
    {
    	if(r != null)
    	{
    		System.out.println(spacer + r.rule);
    		for(DottedRule i : r.children)
    		{
    			prettyPrintParseTree(i, spacer + "\t");
    		}
    	}
    }

    public DottedRule makeLambaToStartRule()
    {
        Rule temp = new Rule();
        temp.lhs = "lambda";
        temp.rhs.add(startingSymbols.get(0));//Should only ever be one starting symbol

        return new DottedRule(temp, 0,0,0);
    }

    public int loadListsAndInputString()
    {
    	System.out.println("PREPPING RECOGNIZER->");
    	
        loadFromFile_theLists_ruleS_variableS_terminalS_startingS();
        loadRulesList();

        ArrayList<String> inputTokens = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(argsCLA[1]," ");
        while (tokenizer.hasMoreTokens())
            inputTokens.add(tokenizer.nextToken());
        
        for(int i = 0; i < inputTokens.size(); i++)//Loads "words" of input string
        {
            String temp  = inputTokens.get(i);
            temp = temp.toLowerCase();     
            if(temp.endsWith(".") && (i == inputTokens.size() - 1))//last word might have a period
                temp = temp.substring(0, temp.length() - 1);      
            words.add(temp);
        }
        System.out.println("  inputString: \t\t\t " + argsCLA[1]);
        System.out.println("  inputStringTokenized: \t " + words.toString());
        System.out.println("<-END RECOGNIZER PREP.\n");
        
        return inputTokens.size() + 1;
    }

    public void loadFromFile_theLists_ruleS_variableS_terminalS_startingS()
    {
        List<String> fromFile = null;

        try
        {
            BufferedReader in = new BufferedReader(new FileReader(argsCLA[0]));  
            while(in.ready())
            {
                String text = in.readLine();

                if(text.equals("<S>"))
                {
                    fromFile = startingSymbols;
                    text = in.readLine();
                }              
                if(text.equals("<E>"))
                {
                    fromFile = epsilonSymbols;
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
                while(!text.equals("</S>") && !text.equals("</E>") && !text.equals("</V>") && 
                	  !text.equals("</T>") && !text.equals("</P>"))
                {
                    fromFile.add(text);
                    text = in.readLine();
                }
            }
            in.close();
        }catch(Exception e){System.out.println("Could not process file. Check name and/or format."); System.exit(0);}

        System.out.println("  startingSymbols:\t\t " 	+ startingSymbols.toString());
        System.out.println("  epsilonSymbols: \t\t " 	+ epsilonSymbols.toString());
        System.out.println("  variableSymbols:\t\t " 	+ variableSymbols.toString());
        System.out.println("  terminalSymbols:\t\t " 	+ terminalSymbols.toString());
        //System.out.println("  ruleStrings:    \t\t " 	+ ruleStrings.toString());
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
                    if(temp.equals("NULL") || epsilonSymbols.contains(temp))
                    	epsilonProductionVariables.add(tempRule.lhs);     	
                }
                index++;
            }
            rules.add(tempRule);
        }
        System.out.println("  rules: \t\t\t " + rules.toString());
        System.out.println("  epsilonProductionVariables: \t " + epsilonProductionVariables.toString());
        
        loadPartsOfSpeechHashtable();
        checkForMixedTerminalsAndNonterminals();
    }//end method loadRulesList()
    
    int newVariableCounter = 0;
    public void  checkForMixedTerminalsAndNonterminals()
    {
    	ArrayList<Rule> newRules = new ArrayList<Rule>();
    	for (int i = 0; i < rules.size(); i++)
    	{
    		Rule temp = rules.get(i);
    		for (int j = 0; j < temp.rhs.size(); j++)
    		{
    			if(temp.rhs.size() > 1 && terminalSymbols.contains(temp.rhs.get(j)))
    			{
    				String V = partsOfSpeech.get(temp.rhs.get(j));
    				if(V == null)
    				{
    					V = "v" + newVariableCounter++;
    					variableSymbols.add(V);
    					partsOfSpeech.put(temp.rhs.get(j), V);
    					
    					Rule newRule = new Rule();
	    				newRule.lhs = V;
	    				newRule.rhs.add(temp.rhs.get(j));
	    				newRules.add(newRule);
    				}
    				temp.rhs.set(j, V);
    			}
    		}
    	}
    	rules.addAll(newRules);
    	
    	System.out.println("  NEW rules list: \t\t " + rules.toString());
    	System.out.println("  NEW variableSymbols list: \t " + variableSymbols.toString());
    	System.out.println("  NEW partsOfSpeech list: \t " + partsOfSpeech.toString()); 
    }

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
        System.out.println("  partsOfSpeech: \t\t " + partsOfSpeech.toString());
    }//end method loadPartsOfSpeechHashtable()

    public void printChart()
    {
        System.out.println("CHART->");

        int chartEntry = 0;
        for (ArrayList<DottedRule> i : chart)
        {
            System.out.println("  " + chartEntry + " START*********************************");
            for (DottedRule r: i)
                System.out.println("     " + r);
            System.out.println("  " + chartEntry + " END***********************************");
            chartEntry++;
        }
        
        System.out.println("<-END CHART");
    }
}//end class EarleyRecognizer
	