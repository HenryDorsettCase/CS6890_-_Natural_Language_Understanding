import java.util.*;


public class StringIntoListToParse 
{
	private LinkedList<String> parsed;
	private String stringToLoadIntoAList;
	
	public StringIntoListToParse()
	{
		parsed = new LinkedList<String>();	
	}
	
	public LinkedList<String> getListVersionOfString(String in)
	{
		parsed.clear();
		
		stringToLoadIntoAList = in;

		while (!stringToLoadIntoAList.isEmpty())
		{
			//stem
			if(stringToLoadIntoAList.charAt(0)!= '+' && stringToLoadIntoAList.charAt(0)!= '^' && !stringToLoadIntoAList.equals("ed#")) 
			{
				String temp = stringToLoadIntoAList.substring(0, 1);
				parsed.addLast(temp);
				stringToLoadIntoAList = stringToLoadIntoAList.substring(1);
			}
			else if(stringToLoadIntoAList.equals("ed#"))
			{
				parsed.addLast("ed#");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(3);
			}
			else if(stringToLoadIntoAList.contains("^s"))
			{
				parsed.addLast("^s#");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(3);
			}
			//pronouns
			else if (stringToLoadIntoAList.contains("+prn")) 
			{
				parsed.addLast("+prn");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(4);
			}
			//nouns
			else if(stringToLoadIntoAList.contains("+n"))
			{
				parsed.addLast("+n");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(2);
			}
			//verbs
			else if(stringToLoadIntoAList.contains("+v"))
			{
				parsed.addLast("+v");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(2);
			}
			//forms - tense
			else if(stringToLoadIntoAList.contains("+past_form"))
			{
				parsed.addLast("+past_form");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(10);
			}
			else if(stringToLoadIntoAList.contains("+past_part"))
			{
				parsed.addLast("+past_part");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(10);
			}
			else if(stringToLoadIntoAList.contains("+pres_form"))
			{
				parsed.addLast("+pres_form");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(10);
			}
			//123SPMF
			else if (stringToLoadIntoAList.contains("+1sg"))
			{
				parsed.addLast("+1sg");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(4);
			}
			else if (stringToLoadIntoAList.contains("+1pl"))
			{
				parsed.addLast("+1pl");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(4);
			}
			else if (stringToLoadIntoAList.contains("+3sg"))
			{
				parsed.addLast("+3sg");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(4);
			}
			else if (stringToLoadIntoAList.contains("+musc"))
			{
				parsed.addLast("+musc");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(5);
			}
			else if (stringToLoadIntoAList.contains("+fem"))
			{
				parsed.addLast("+fem");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(4);
			}
			else if(stringToLoadIntoAList.contains("+pl"))
			{
				parsed.addLast("+pl");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(3);
			}
			else if(stringToLoadIntoAList.contains("+sg"))
			{
				parsed.addLast("+sg");
				stringToLoadIntoAList = stringToLoadIntoAList.substring(3);
			}
		}//while (!stringToLoadIntoAList.isEmpty())
				
		return parsed;
	}//
		
	public void printListVersionOfString(LinkedList<String> in)
	{
		for(String s: in)
		{
			System.out.println(s);
		}
		System.out.println();
	}
		
}//end class

