public class PartOfSpeech 	
{
    String variable;
    String terminal;

    public PartOfSpeech(String lhs, String rhs)
    {
        variable = lhs;
        terminal = rhs;
    }

    public String getVariable(String rhs)
    {
        if (rhs.equals(terminal)) return variable;
        else return null;
    }
}
