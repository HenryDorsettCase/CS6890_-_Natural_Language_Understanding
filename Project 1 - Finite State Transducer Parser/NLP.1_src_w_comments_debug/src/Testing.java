import java.util.*;

import jdsl.graph.api.Edge;
import jdsl.graph.api.EdgeIterator;
import jdsl.graph.api.Vertex;
import jdsl.graph.api.VertexIterator;

public class Testing {

	public static void main(String[] args) 
	{
		
		String other = "abcdefghijklmnopqrstuvwxyz#+_";
		
		for(int i = 0; i < other.length(); i++)
		{
			String result = other.substring(i, i+1);
			System.out.println(i + ": " + result);	
		}
	}
}



