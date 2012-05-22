
import java.util.*;

public class Rule
{
    String lhs;
    List<String> rhs;

    public Rule()
    {
        rhs = new ArrayList<String>();
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

    public boolean isTheRightLexicalRule(String l, String r)
    {
        if (l.equals(this.lhs) && r.equals(this.rhs.get(0))) return true;
        else return false;
    }
}
