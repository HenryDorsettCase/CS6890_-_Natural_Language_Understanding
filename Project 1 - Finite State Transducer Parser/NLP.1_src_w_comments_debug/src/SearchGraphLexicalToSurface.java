import java.util.*;
import java.io.*;

import jdsl.*;
import jdsl.graph.api.*;
import jdsl.graph.ref.*;
import jdsl.graph.algo.*;


public class SearchGraphLexicalToSurface 
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
	
	public SearchGraphLexicalToSurface()
	{	
	}
	
	public String BFS(Graph g, Vertex start, Vertex end,  LinkedList<String> strToParse)
	{
		String parsed = "";
		LinkedList<VISTriple> q = new LinkedList<VISTriple>();
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		//System.out.println("parsed: " + parsed);
		
		q.push( new VISTriple(0,start,""));
		//System.out.println(q.peek().ver);
		
		while(!q.isEmpty())
		{
			try
			{
				//reader.readLine();
			}catch (Exception e){}
			
			VISTriple v = q.removeFirst();
			//System.out.println("WHILE: " + v);
			
			LinkedList<Edge> successors = new LinkedList<Edge>();
			successors.clear();
			
			EdgeIterator ei = g.incidentEdges(v.ver);
			//System.out.println("Getting incident edges:");
			while (ei.hasNext())
			{
				Edge temp = ei.nextEdge();
				if(g.origin(temp)== v.ver)
				{
					successors.addFirst(temp);
					//System.out.println(successors.peekFirst().toString());
				}
			}
			
			if(v.ind >= strToParse.size() && v.ver.equals(end))
			{
				//System.out.println("*result: " + v.result);
				return v.result;
			}
			
			String toFind ="";
			if(v.ind < strToParse.size())
			{
				toFind = strToParse.get(v.ind);
			}
			else
				toFind ="";
			
			//System.out.println("toFind: " + toFind);
			
			for(int i = 0; i < successors.size(); i++)
			{
				Edge e = successors.get(i);
				EdgeTuple tempET = (EdgeTuple)e.element();
				//System.out.println("tempET: " + tempET);
				if(tempET.lhs.equals("") || tempET.lhs.equals(toFind))
				{
					Vertex w = g.destination(e);
					if(tempET.lhs.equals(toFind))
					{
						q.addFirst(new VISTriple(v.ind+1,w, v.result + tempET.rhs));
						//System.out.println("found LHS: " + q.peekFirst());
					}
					else
					{
						q.addFirst(new VISTriple(v.ind,w, v.result + tempET.rhs));
						//System.out.println("!found LHS: " + q.peekFirst());
					}
				}//end if
			}//end for
		}//end while
		return "";
	}//end BFS

}
