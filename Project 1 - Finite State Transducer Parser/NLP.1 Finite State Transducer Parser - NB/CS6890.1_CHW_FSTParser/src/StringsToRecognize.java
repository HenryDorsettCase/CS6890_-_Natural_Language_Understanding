import java.util.*;

public class StringsToRecognize 
{
	private LinkedList<String> stringSet;
	
	public StringsToRecognize()
	{
		stringSet = new LinkedList<String>();
		LoadList();
	}
	
	private void LoadList()
	{
		//LEXICAL

		//PRONOUNS 0-3
		stringSet.addLast("+prn+1sg");
		stringSet.addLast("+prn+3sg+musc");
		stringSet.addLast("+prn+3sg+fem");
		stringSet.addLast("+prn+1pl");

		//NOUNS 4-9
		stringSet.addLast("fox+n+sg");
		stringSet.addLast("fox+n+pl");
		stringSet.addLast("finch+n+sg");
		stringSet.addLast("finch+n+pl");
		stringSet.addLast("goose+n+sg");
		stringSet.addLast("goose+n+pl");

		//VERBS 10-20
		stringSet.addLast("fox+v+pres_form+3sg");
		stringSet.addLast("burn+v+past_form");
		stringSet.addLast("burn+v+past_part");
		stringSet.addLast("catch+v+past_form");
		stringSet.addLast("catch+v+past_part");
		stringSet.addLast("speak+v+past_form");
		stringSet.addLast("speak+v+past_part");
		stringSet.addLast("see+v+past_form");
		stringSet.addLast("see+v+past_part");
		stringSet.addLast("see+v+pres_form+pl");
		stringSet.addLast("see+v+pres_form+3sg");
		
		//SURFACE

		//PRONOUNS 21-24
		stringSet.addLast("i#");
		stringSet.addLast("he#");
		stringSet.addLast("she#");
		stringSet.addLast("we#");

		//NOUNS 25-30 - temporarily inserting carat
		stringSet.addLast("fox#");
		stringSet.addLast("foxes#");
		stringSet.addLast("finch#");
		stringSet.addLast("finches#");
		stringSet.addLast("goose#");
		stringSet.addLast("geese#");
		
		//VERBS 31-39
		stringSet.addLast("foxes#");
		stringSet.addLast("burned#");
		stringSet.addLast("caught#");
		stringSet.addLast("spoke#");
		stringSet.addLast("spoken#");
		stringSet.addLast("saw#");
		stringSet.addLast("seen#");
		stringSet.addLast("see#");
		stringSet.addLast("sees#");
	}
	
	public LinkedList<String> getList()
	{
		return stringSet;
	}
	
	public String getFirstStringToParse()
	{
		return stringSet.removeFirst();
	}
	
}//end class