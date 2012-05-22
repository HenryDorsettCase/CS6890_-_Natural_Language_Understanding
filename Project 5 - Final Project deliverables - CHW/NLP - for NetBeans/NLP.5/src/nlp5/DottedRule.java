package nlp5;

import java.util.*;

public class DottedRule extends Rule
{
    Rule rule;
    int dot;
    int start;
    int end;
    
    ArrayList<DottedRule> children;
    
    DottedRule(Rule origin, int dotIndex, int startInputPosition, int endInputPosition)
    {
        rule = origin;
        dot = dotIndex;
        start = startInputPosition;
        end = endInputPosition;
        
        children = new ArrayList<DottedRule>();
    }

    public boolean isComplete()
    {
        if(dot == rule.rhs.size()) return true;
        else return false;
    }
    
    public String nextV()
    {
        if(isComplete())return null;
        else return rule.rhs.get(dot);
    }

    public String toString()
    {
    	String c_List = "";
    	for(int i = 0; i < children.size(); i++)
    	{
    		c_List += children.get(i).rule;
    		if(i != children.size()-1)
    			c_List += ", ";	
    	}
    	
    	String result = "dot=" + dot + " start=" + start + " end= " + end + ", rule-> " + rule;
    	if(EarleyRecognizer.debug) result += ", children-> " + c_List;
    	
        return result;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DottedRule p = (DottedRule) o;//p for parameter

        if (this.dot == p.dot && this.start == p.start && this.end == p.end &&
                this.rule.lhs.equals(p.rule.lhs) && this.rule.rhs.equals(p.rule.rhs))
        {
            return true;
        }
        else return false;
    }
}
