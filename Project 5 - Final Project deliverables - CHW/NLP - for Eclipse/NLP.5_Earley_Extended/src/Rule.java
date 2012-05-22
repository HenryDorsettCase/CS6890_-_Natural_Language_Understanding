import java.util.*;

public class Rule
{
    String lhs;
    List<String> rhs;

    public Rule()
    {
        rhs = new ArrayList<String>();
    }
    
    public static Rule makeEpsilonRule(String l)
    {
    	Rule temp = new Rule();
    	temp.lhs = l;
    	temp.rhs.add("NULL");
    	
    	return temp;
    }
    
    public boolean isEpsilonRule()
    {
    	if(rhs.size() == 1 && rhs.get(0).equals("NULL"))  return true;
    	else return false;
    }

    public String toString()
    {
        String rhs_temp = "";

        for (int i = 0; i < rhs.size(); i++)
        {
            rhs_temp += rhs.get(i);
            if (i != rhs.size() - 1)
                rhs_temp += " ";
        }
        return lhs + " ::= " + rhs_temp;
    }
    
    public String rhs_toString()
    {
    	String rhs_temp = "";

        for (int i = 0; i < rhs.size(); i++)
        {
            rhs_temp += rhs.get(i);
            if (i != rhs.size() - 1)
                rhs_temp += " ";
        }
        return rhs_temp;
    }

    public boolean isTheRightLexicalRule(String l, String r)
    {
        if (l.equals(this.lhs) && r.equals(this.rhs.get(0))) return true;
        else return false;
    }
    
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Rule p = (Rule) o;//p for parameter

        if (this.lhs.equals(p.lhs) && this.rhs.equals(p.rhs))
        {
            return true;
        }
        else
            return false;
    }
}
