import java.util.*;

public class Test_FSTParser
{
    public Test_FSTParser()
    {
        System.out.println("FST & MORPHOLOGY - CS6890 PROJECT ONE");
    }


    public static void main(String args[])
    {
       Test_FSTParser t = new Test_FSTParser();

       if(args.length > 0)//RUN COMMAND LINE STRING(S)
       {
    	   System.out.println();
    	   System.out.print("Command Line String: ");
    	   for (String s: args)
    		   System.out.print(s + " ");
    	   System.out.println("\n");

    	   for (String s: args)
    	   {
    		   t.RunWordThroughFSTs(s);
    		   System.out.println();
    	   }
       }
       else//RUN LIST OF ALL STRINGS OF PROJECT
    	   t.RunListThroughFSTs();
    }
    public void RunWordThroughFSTs(String stringToTransform)
    {
		StringIntoListToParse sILTP = new StringIntoListToParse();
		LinkedList<String> resultList;
		LinkedList<String> loaded;

		System.out.println("String To Transform : " + stringToTransform);
		loaded = sILTP.getListVersionOfString(stringToTransform);

		if(stringToTransform.contains("+"))//LEXICAL TO INTERMEDIATE TO SURFACE
		{
			BuildGraphsLexicalToSurface gB = new BuildGraphsLexicalToSurface();
			SearchGraphLexicalToSurface sG = new SearchGraphLexicalToSurface();

			String result = sG.BFS(gB.nounGraph, gB.startNGV, gB.endNGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}

			loaded = sILTP.getListVersionOfString(stringToTransform);
			result = sG.BFS(gB.verbGraph, gB.startVGV, gB.endVGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}

			loaded = sILTP.getListVersionOfString(stringToTransform);
			result = sG.BFS(gB.pronounGraph, gB.startPGV, gB.endPGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}
		}
		else//SURFACE TO INTERMEDIATE TO LEXICAL
		{
			BuildGraphsSurfaceToLexical gB1 = new BuildGraphsSurfaceToLexical();
			SearchGraphSurfaceToLexical sG1 = new SearchGraphSurfaceToLexical();

			String result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.nounGraph, gB1.startNGV, gB1.endNGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);

				loaded = sILTP.getListVersionOfString(stringToTransform);
				result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.verbGraph, gB1.startVGV, gB1.endVGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);

				loaded = sILTP.getListVersionOfString(stringToTransform);
				result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.pronounGraph, gB1.startPGV, gB1.endPGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}
		}
    }

    public void RunListThroughFSTs()
    {
		StringsToRecognize sTR = new StringsToRecognize();
		LinkedList<String> list = sTR.getList();
		StringIntoListToParse sILTP = new StringIntoListToParse();
		LinkedList<String> resultList;
		LinkedList<String> loaded;
		String stringToTransform;

		System.out.println("\n************************************************");
		System.out.println("LEXICAL TO INTERMEDIATE TO SURFACE...");
		System.out.println("************************************************\n");

		//LEXICAL TO INTERMEDIATE TO SURFACE
		BuildGraphsLexicalToSurface gB = new BuildGraphsLexicalToSurface();
		SearchGraphLexicalToSurface sG = new SearchGraphLexicalToSurface();
		for(int i = 0; i < 21; i++)
		{
			stringToTransform = list.get(i);
			System.out.println("String To Transform : " + stringToTransform);
			loaded = sILTP.getListVersionOfString(stringToTransform);

			String result = sG.BFS(gB.nounGraph, gB.startNGV, gB.endNGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}

			loaded = sILTP.getListVersionOfString(stringToTransform);
			result = sG.BFS(gB.verbGraph, gB.startVGV, gB.endVGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}

			loaded = sILTP.getListVersionOfString(stringToTransform);
			result = sG.BFS(gB.pronounGraph, gB.startPGV, gB.endPGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG.BFS(gB.eRuleGraph, gB.startEGV, gB.endEGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}
			System.out.println();
		}

		System.out.println("************************************************");
		System.out.println("SURFACE TO INTERMEDIATE TO LEXICAL...");
		System.out.println("************************************************\n");

		//SURFACE TO INTERMEDIATE TO LEXICAL
		BuildGraphsSurfaceToLexical gB1 = new BuildGraphsSurfaceToLexical();
		SearchGraphSurfaceToLexical sG1 = new SearchGraphSurfaceToLexical();
		for(int i = 21; i < list.size(); i++)
		{
			stringToTransform = list.get(i);
			System.out.println("String To Transform : " + stringToTransform);
			loaded = sILTP.getListVersionOfString(stringToTransform);

			String result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
			if(!result.isEmpty())
			{
				System.out.println("Intermediate        : " + result);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.nounGraph, gB1.startNGV, gB1.endNGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);

				loaded = sILTP.getListVersionOfString(stringToTransform);
				result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.verbGraph, gB1.startVGV, gB1.endVGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);

				loaded = sILTP.getListVersionOfString(stringToTransform);
				result = sG1.BFS(gB1.eRuleGraph, gB1.startEGV, gB1.endEGV, loaded);
				resultList  = sILTP.getListVersionOfString(result);
				result = sG1.BFS(gB1.pronounGraph, gB1.startPGV, gB1.endPGV, resultList);
				if(!result.isEmpty())
					System.out.println("Result              : " + result);
			}
			System.out.println();
		}
    }

}
