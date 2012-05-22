import java.util.*;
import jdsl.graph.api.Edge;
import jdsl.graph.api.EdgeIterator;
import jdsl.graph.api.Graph;
import jdsl.graph.api.Vertex;


public class SearchGraphSurfaceToLexical 
{
	class VISTriple
	{
		int ind;
		Vertex ver;
		String result;
		
		public VISTriple(int i, Vertex v, String r)
		{
			ind = i;
			ver = v;
			result = r;
		}
		
		public String toString()
		{
			return ind + ":" + ver + ":" + result;
		}
	}
	
	public SearchGraphSurfaceToLexical()
	{			
	}
	
	public String BFS(Graph g, Vertex start, Vertex end, LinkedList<String> strToParse)
	{
		LinkedList<VISTriple> q = new LinkedList<VISTriple>();

		q.push( new VISTriple(0,start,""));
		
		while(!q.isEmpty())
		{		
			VISTriple v = q.removeFirst();
			
			LinkedList<Edge> successors = new LinkedList<Edge>();
			successors.clear();
			
			EdgeIterator ei = g.incidentEdges(v.ver);
			while (ei.hasNext())
			{
				Edge temp = ei.nextEdge();
				if(g.origin(temp)== v.ver)
				{
					successors.addFirst(temp);
				}
			}
			if((v.ind >= strToParse.size()) && (v.ver.equals(end)))
			{
				return v.result;
			}
			
			String toFind ="";
			if(v.ind < strToParse.size())
			{
				toFind = strToParse.get(v.ind);
			}
			else
				toFind ="";
			
			for(int i = 0; i < successors.size(); i++)
			{
				Edge e = successors.get(i);
				EdgeTuple tempET = (EdgeTuple)e.element();
				
				if(tempET.lhs.equals(toFind) || tempET.lhs.equals(""))
				{
					Vertex w = g.destination(e);
					if(tempET.lhs.equals(toFind))
					{
						q.addFirst(new VISTriple(v.ind+1,w, v.result + tempET.rhs));
					}
					else
					{
						q.addFirst(new VISTriple(v.ind,w, v.result + tempET.rhs));
					}
				}//end if
			}//end for
		}//end while
		
		return "";
	}//end BFS


}
