
public class EdgeTuple 
{
	public String lhs; 
	public String rhs;
	
	public EdgeTuple(String lhs, String rhs)
	{
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString()
	{
		return lhs + ":" + rhs; 
	}
	
}//end class
