import java.util.*;
import jdsl.*;
import jdsl.graph.api.*;
import jdsl.graph.ref.*;
import jdsl.graph.algo.*;

public class BuildGraphsLexicalToSurface 
{
	public Graph pronounGraph;
	public Graph verbGraph;
	public Graph nounGraph;
	public Graph eRuleGraph;
	
	Vertex startPGV;
	Vertex endPGV;
	
	Vertex startVGV;
	Vertex endVGV;
	
	Vertex startNGV;
	Vertex endNGV;
	
	Vertex startEGV;
	Vertex endEGV;

	public BuildGraphsLexicalToSurface()
	{
		pronounGraph = new IncidenceListGraph();
		verbGraph = new IncidenceListGraph();
		nounGraph = new IncidenceListGraph();
		eRuleGraph = new IncidenceListGraph();
		
		buildPronounGraph();
		buildVerbGraph();
		buildNounGraph();
		buildERuleGraph();
	}
	
	private void buildPronounGraph()
	{
		Vertex v0 	= pronounGraph.insertVertex(0);
		Vertex v1 	= pronounGraph.insertVertex(1);
		Vertex v2 	= pronounGraph.insertVertex(2);
		Vertex v3 	= pronounGraph.insertVertex(3);
		Vertex v4 	= pronounGraph.insertVertex(4);
		Vertex v5 	= pronounGraph.insertVertex(5);
		Vertex v6 	= pronounGraph.insertVertex(6);
		Vertex v7 	= pronounGraph.insertVertex(7);
		Vertex v8 	= pronounGraph.insertVertex(8);
		Vertex v9 	= pronounGraph.insertVertex(9);
		Vertex v10 	= pronounGraph.insertVertex(10);
		Vertex v11 	= pronounGraph.insertVertex(11);
		Vertex v12 	= pronounGraph.insertVertex(12);
		Vertex v13 	= pronounGraph.insertVertex(13);
		Vertex v14 	= pronounGraph.insertVertex(14);
		Vertex v15 	= pronounGraph.insertVertex(15);
			
		startPGV = v0;
		endPGV = v11;
		
		Edge e1 = pronounGraph.insertDirectedEdge(v0, v1, new EdgeTuple("", "i"));
		//Edge e2 = pronounGraph.insertDirectedEdge(v0, v1, new EdgeTuple("i", ""));
		Edge e3 = pronounGraph.insertDirectedEdge(v1, v5, new EdgeTuple("+prn", ""));
		//Edge e4 = pronounGraph.insertDirectedEdge(v1, v5, new EdgeTuple("", "+prn"));
		Edge e5 = pronounGraph.insertDirectedEdge(v5, v11, new EdgeTuple("+1sg", "#"));
		//Edge e6 = pronounGraph.insertDirectedEdge(v5, v11, new EdgeTuple("#", "+1sg"));
		
		Edge e7 = pronounGraph.insertDirectedEdge(v0, v12, new EdgeTuple("", "w"));
		//Edge e8 = pronounGraph.insertDirectedEdge(v0, v12, new EdgeTuple("w", ""));	
		Edge e9 = pronounGraph.insertDirectedEdge(v12, v2, new EdgeTuple("", "e"));
		//Edge e10 = pronounGraph.insertDirectedEdge(v12, v2, new EdgeTuple("e", ""));
		Edge e11 = pronounGraph.insertDirectedEdge(v2, v6, new EdgeTuple("+prn", ""));
		//Edge e12 = pronounGraph.insertDirectedEdge(v2, v6, new EdgeTuple("", "+prn"));
		Edge e13 = pronounGraph.insertDirectedEdge(v6, v11, new EdgeTuple("+1pl", "#"));
		//Edge e14 = pronounGraph.insertDirectedEdge(v6, v11, new EdgeTuple("#", "+1pl"));
		
		Edge e15 = pronounGraph.insertDirectedEdge(v0, v13, new EdgeTuple("", "h"));
		//Edge e16 = pronounGraph.insertDirectedEdge(v0, v13, new EdgeTuple("h", ""));	
		Edge e17 = pronounGraph.insertDirectedEdge(v13, v3, new EdgeTuple("", "e"));
		//Edge e18 = pronounGraph.insertDirectedEdge(v13, v3, new EdgeTuple("e", ""));
		Edge e19 = pronounGraph.insertDirectedEdge(v3, v7, new EdgeTuple("+prn", ""));
		//Edge e20 = pronounGraph.insertDirectedEdge(v3, v7, new EdgeTuple("", "+prn"));
		Edge e21 = pronounGraph.insertDirectedEdge(v7, v9, new EdgeTuple("+3sg", ""));
		//Edge e22 = pronounGraph.insertDirectedEdge(v7, v9, new EdgeTuple("", "+3sg"));
		Edge e23 = pronounGraph.insertDirectedEdge(v9, v11, new EdgeTuple("+musc", "#"));
		//Edge e24 = pronounGraph.insertDirectedEdge(v9, v11, new EdgeTuple("#", "+musc"));
		
		Edge e25 = pronounGraph.insertDirectedEdge(v0, v14, new EdgeTuple("", "s"));
		//Edge e26 = pronounGraph.insertDirectedEdge(v0, v14, new EdgeTuple("s", ""));	
		Edge e27 = pronounGraph.insertDirectedEdge(v14, v15, new EdgeTuple("", "h"));
		//Edge e28 = pronounGraph.insertDirectedEdge(v14, v15, new EdgeTuple("h", ""));	
		Edge e29 = pronounGraph.insertDirectedEdge(v15, v4, new EdgeTuple("", "e"));
		//Edge e30 = pronounGraph.insertDirectedEdge(v15, v4, new EdgeTuple("e", ""));
		Edge e31 = pronounGraph.insertDirectedEdge(v4, v8, new EdgeTuple("+prn", ""));
		//Edge e32 = pronounGraph.insertDirectedEdge(v4, v8, new EdgeTuple("", "+prn"));
		Edge e33 = pronounGraph.insertDirectedEdge(v8, v10, new EdgeTuple("+3sg", ""));
		//Edge e34 = pronounGraph.insertDirectedEdge(v8, v10, new EdgeTuple("", "+3sg"));
		Edge e35 = pronounGraph.insertDirectedEdge(v10, v11, new EdgeTuple("+fem", "#"));
		//Edge e36 = pronounGraph.insertDirectedEdge(v10, v11, new EdgeTuple("#", "+fem"));
		
		System.out.println();
//		System.out.println("EDGES");
//		EdgeIterator ei = pronounGraph.edges();
//		while (ei.hasNext())
//		{
//			System.out.println(ei.nextEdge());
//		}
//		
//		System.out.println();
//		System.out.println("VERTEXES");
//		VertexIterator vi = pronounGraph.vertices();
//		while (vi.hasNext())
//		{
//			System.out.println(vi.nextVertex());
//		}
	}
	
	private void buildVerbGraph()
	{
		Vertex v0 	= verbGraph.insertVertex(0);
		Vertex v1 	= verbGraph.insertVertex(1);
		Vertex v2 	= verbGraph.insertVertex(2);
		Vertex v3 	= verbGraph.insertVertex(3);
		Vertex v4 	= verbGraph.insertVertex(4);
		Vertex v5 	= verbGraph.insertVertex(5);
		Vertex v6 	= verbGraph.insertVertex(6);
		Vertex v7 	= verbGraph.insertVertex(7);
		Vertex v8 	= verbGraph.insertVertex(8);
		Vertex v9 	= verbGraph.insertVertex(9);
		Vertex v10 	= verbGraph.insertVertex(10);
		Vertex v11 	= verbGraph.insertVertex(11);
		Vertex v12 	= verbGraph.insertVertex(12);
			
		startVGV = v0;
		endVGV = v8;
		
		Edge e1 = verbGraph.insertDirectedEdge(v1, v4, new EdgeTuple("+v", ""));
		//Edge e2 = verbGraph.insertDirectedEdge(v1, v4, new EdgeTuple("", "+v"));
		Edge e3 = verbGraph.insertDirectedEdge(v2, v5, new EdgeTuple("+v", ""));
		//Edge e4 = verbGraph.insertDirectedEdge(v2, v5, new EdgeTuple("", "+v"));
		Edge e5 = verbGraph.insertDirectedEdge(v3, v6, new EdgeTuple("+v", ""));
		//Edge e6 = verbGraph.insertDirectedEdge(v3, v6, new EdgeTuple("", "+v"));
		Edge e7 = verbGraph.insertDirectedEdge(v9, v10, new EdgeTuple("+v", ""));
		//Edge e8 = verbGraph.insertDirectedEdge(v9, v10, new EdgeTuple("", "+v"));
		Edge e9 = verbGraph.insertDirectedEdge(v11, v12, new EdgeTuple("+v", ""));
		//Edge e10 = verbGraph.insertDirectedEdge(v11, v12, new EdgeTuple("", "+v"));
		
		Edge e11 = verbGraph.insertDirectedEdge(v4, v8, new EdgeTuple("+past_form", "ed#"));
		//Edge e12 = verbGraph.insertDirectedEdge(v4, v8, new EdgeTuple("ed#", "+past_form"));
		Edge e13 = verbGraph.insertDirectedEdge(v4, v8, new EdgeTuple("+past_part", "ed#"));
		//Edge e14 = verbGraph.insertDirectedEdge(v4, v8, new EdgeTuple("ed#", "+past_part"));
		
		Edge e15 = verbGraph.insertDirectedEdge(v6, v8, new EdgeTuple("+past_form", "#"));
		//Edge e16 = verbGraph.insertDirectedEdge(v6, v8, new EdgeTuple("#", "+past_form"));
		Edge e17 = verbGraph.insertDirectedEdge(v6, v8, new EdgeTuple("+past_part", "#"));
		//Edge e18 = verbGraph.insertDirectedEdge(v6, v8, new EdgeTuple("#", "+past_part"));
		
		Edge e19 = verbGraph.insertDirectedEdge(v10, v8, new EdgeTuple("+past_form", "#"));
		//Edge e20 = verbGraph.insertDirectedEdge(v10, v8, new EdgeTuple("#", "+past_form"));
		
		Edge e21 = verbGraph.insertDirectedEdge(v12, v8, new EdgeTuple("+past_part", "#"));
		//Edge e22 = verbGraph.insertDirectedEdge(v12, v8, new EdgeTuple("#", "+past_part"));
		
		Edge e23 = verbGraph.insertDirectedEdge(v5, v7, new EdgeTuple("+pres_form", ""));
		Edge e24 = verbGraph.insertDirectedEdge(v5, v7, new EdgeTuple("", "+pres_form"));
		
		Edge e25 = verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("+3sg", "^s#"));
		//Edge e26 = verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("^s#", "+3sg"));	
		Edge e27 = verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("+pl", "#"));
		//Edge e28 = verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("#", "+pl"));
		
		//STEMS
		
		Vertex v13 	= verbGraph.insertVertex(13);
		Vertex v14 	= verbGraph.insertVertex(14);
		Vertex v15 	= verbGraph.insertVertex(15);
		Vertex v16 	= verbGraph.insertVertex(16);
		Vertex v17 	= verbGraph.insertVertex(17);
		Vertex v18 	= verbGraph.insertVertex(18);
		Vertex v19 	= verbGraph.insertVertex(19);
		Vertex v20 	= verbGraph.insertVertex(20);
		Vertex v21 	= verbGraph.insertVertex(21);
		Vertex v22 	= verbGraph.insertVertex(22);
		Vertex v23 	= verbGraph.insertVertex(23);
		Vertex v24 	= verbGraph.insertVertex(24);
		Vertex v25 	= verbGraph.insertVertex(25);
		Vertex v26 	= verbGraph.insertVertex(26);
		Vertex v27 	= verbGraph.insertVertex(27);
		Vertex v28 	= verbGraph.insertVertex(28);
		Vertex v29 	= verbGraph.insertVertex(29);
		Vertex v30 	= verbGraph.insertVertex(30);
		Vertex v31 	= verbGraph.insertVertex(31);
		Vertex v32 	= verbGraph.insertVertex(32);
		Vertex v33 	= verbGraph.insertVertex(33);
		Vertex v34 	= verbGraph.insertVertex(34);
		Vertex v35 	= verbGraph.insertVertex(35);
		Vertex v36 	= verbGraph.insertVertex(36);
		
		Edge e29 = verbGraph.insertDirectedEdge(v0, v13, new EdgeTuple("b", "b"));
		Edge e30 = verbGraph.insertDirectedEdge(v13, v14, new EdgeTuple("u", "u"));		
		Edge e31 = verbGraph.insertDirectedEdge(v14, v15, new EdgeTuple("r", "r"));
		Edge e32 = verbGraph.insertDirectedEdge(v15, v1, new EdgeTuple("n", "n"));
		
		Edge e33 = verbGraph.insertDirectedEdge(v0, v16, new EdgeTuple("c", "c"));
		Edge e34 = verbGraph.insertDirectedEdge(v16, v17, new EdgeTuple("a", "a"));
		Edge e35 = verbGraph.insertDirectedEdge(v17, v18, new EdgeTuple("t", "u"));
		//Edge e36 = verbGraph.insertDirectedEdge(v17, v18, new EdgeTuple("u", "t"));	
		Edge e37 = verbGraph.insertDirectedEdge(v18, v19, new EdgeTuple("c", "g"));
		//Edge e38 = verbGraph.insertDirectedEdge(v18, v19, new EdgeTuple("g", "c"));	
		Edge e39 = verbGraph.insertDirectedEdge(v19, v20, new EdgeTuple("h", "h"));
		Edge e40 = verbGraph.insertDirectedEdge(v20, v3, new EdgeTuple("", "t"));
		//Edge e41 = verbGraph.insertDirectedEdge(v20, v3, new EdgeTuple("t", ""));
		
		Edge e42 = verbGraph.insertDirectedEdge(v0, v21, new EdgeTuple("f", "f"));
		Edge e43 = verbGraph.insertDirectedEdge(v21, v22, new EdgeTuple("o", "o"));
		Edge e44 = verbGraph.insertDirectedEdge(v22, v2, new EdgeTuple("x", "x"));
//		

		Edge e45 = verbGraph.insertDirectedEdge(v0, v23, new EdgeTuple("s", "s"));
		Edge e46 = verbGraph.insertDirectedEdge(v23, v24, new EdgeTuple("p", "p"));	
		Edge e47 = verbGraph.insertDirectedEdge(v24, v25, new EdgeTuple("e", "o"));
		//Edge e48 = verbGraph.insertDirectedEdge(v24, v25, new EdgeTuple("o", "e"));	
		Edge e49 = verbGraph.insertDirectedEdge(v25, v26, new EdgeTuple("a", "k"));
		//Edge e50 = verbGraph.insertDirectedEdge(v25, v26, new EdgeTuple("k", "a"));
		Edge e51 = verbGraph.insertDirectedEdge(v26, v27, new EdgeTuple("k", "e"));
		//Edge e52 = verbGraph.insertDirectedEdge(v26, v27, new EdgeTuple("e", "k"));
		Edge e53 = verbGraph.insertDirectedEdge(v27, v9, new EdgeTuple("", ""));
		Edge e54 = verbGraph.insertDirectedEdge(v27, v11, new EdgeTuple("", "n"));
		//Edge e55 = verbGraph.insertDirectedEdge(v27, v11, new EdgeTuple("n", ""));
		
		Edge e56 = verbGraph.insertDirectedEdge(v0, v28, new EdgeTuple("s", "s"));	
		Edge e57 = verbGraph.insertDirectedEdge(v28, v29, new EdgeTuple("e", "a"));
		//Edge e58 = verbGraph.insertDirectedEdge(v28, v29, new EdgeTuple("a", "e"));	
		Edge e59 = verbGraph.insertDirectedEdge(v29, v9, new EdgeTuple("e", "w"));
		//Edge e60 = verbGraph.insertDirectedEdge(v29, v9, new EdgeTuple("w", "e"));
		
		Edge e61 = verbGraph.insertDirectedEdge(v0, v30, new EdgeTuple("s", "s"));
		Edge e62 = verbGraph.insertDirectedEdge(v30, v31, new EdgeTuple("e", "e"));
		Edge e63 = verbGraph.insertDirectedEdge(v31, v32, new EdgeTuple("e", "e"));
		Edge e64 = verbGraph.insertDirectedEdge(v32, v2, new EdgeTuple("", ""));
		Edge e65 = verbGraph.insertDirectedEdge(v32, v33, new EdgeTuple("+v", ""));
		Edge e66 = verbGraph.insertDirectedEdge(v32, v11, new EdgeTuple("", "n"));
		
		Edge e67 = verbGraph.insertDirectedEdge(v33, v34, new EdgeTuple("+pres_form", ""));
		Edge e68 = verbGraph.insertDirectedEdge(v34, v8, new EdgeTuple("+3sg", "s#"));
		//Edge e69 = verbGraph.insertDirectedEdge(v35, v8, new EdgeTuple("+3sg", "s#"));
		

//		System.out.println();
//		System.out.println("EDGES");
//		EdgeIterator ei = verbGraph.edges();
//		while (ei.hasNext())
//		{
//			System.out.println(ei.nextEdge());
//		}
//		
//		System.out.println();
//		System.out.println("VERTEXES");
//		VertexIterator vi = verbGraph.vertices();
//		while (vi.hasNext())
//		{
//			System.out.println(vi.nextVertex());
//		}
	}
	
	private void buildNounGraph()
	{
		Vertex v0 	= nounGraph.insertVertex(0);
		Vertex v1 	= nounGraph.insertVertex(1);
		Vertex v2 	= nounGraph.insertVertex(2);
		Vertex v3 	= nounGraph.insertVertex(3);
		Vertex v4 	= nounGraph.insertVertex(4);
		Vertex v5 	= nounGraph.insertVertex(5);
		Vertex v6 	= nounGraph.insertVertex(6);
		Vertex v7 	= nounGraph.insertVertex(7);

		startNGV = v0;
		endNGV = v7;
		
		Edge e1 = nounGraph.insertDirectedEdge(v1, v4, new EdgeTuple("+n", ""));
		//Edge e2 = nounGraph.insertDirectedEdge(v1, v4, new EdgeTuple("", "+n"));
		Edge e3 = nounGraph.insertDirectedEdge(v2, v5, new EdgeTuple("+n", ""));
		//Edge e4 = nounGraph.insertDirectedEdge(v2, v5, new EdgeTuple("", "+n"));
		Edge e5 = nounGraph.insertDirectedEdge(v3, v6, new EdgeTuple("+n", ""));
		//Edge e6 = nounGraph.insertDirectedEdge(v3, v6, new EdgeTuple("", "+n"));

		Edge e7 = nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("+pl", "^s#"));
		//Edge e8 = nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("^s#", "+pl"));
		Edge e9 = nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("+sg", "#"));
		//Edge e10 = nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("#", "+sg"));
		
		Edge e11 = nounGraph.insertDirectedEdge(v5, v7, new EdgeTuple("+sg", "#"));
		//Edge e12 = nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("#", "+sg"));
		
		Edge e13 = nounGraph.insertDirectedEdge(v6, v7, new EdgeTuple("+pl", "#"));
		//Edge e14 = nounGraph.insertDirectedEdge(v6, v7, new EdgeTuple("#", "+pl"));

		
		//STEMS
		
		Vertex v8 	= nounGraph.insertVertex(8);
		Vertex v9 	= nounGraph.insertVertex(9);
		Vertex v10 	= nounGraph.insertVertex(10);
		Vertex v11 	= nounGraph.insertVertex(11);
		Vertex v12 	= nounGraph.insertVertex(12);
		Vertex v13 	= nounGraph.insertVertex(13);
		Vertex v14 	= nounGraph.insertVertex(14);
		Vertex v15 	= nounGraph.insertVertex(15);
		Vertex v16 	= nounGraph.insertVertex(16);
		Vertex v17 	= nounGraph.insertVertex(17);
		Vertex v18 	= nounGraph.insertVertex(18);
		Vertex v19 	= nounGraph.insertVertex(19);
		Vertex v20 	= nounGraph.insertVertex(20);
		Vertex v21 	= nounGraph.insertVertex(21);
		
		Edge e15 = nounGraph.insertDirectedEdge(v0, v8, new EdgeTuple("f", "f"));
		Edge e16 = nounGraph.insertDirectedEdge(v8, v9, new EdgeTuple("o", "o"));	
		Edge e17 = nounGraph.insertDirectedEdge(v9, v1, new EdgeTuple("x", "x"));
		
		Edge e18 = nounGraph.insertDirectedEdge(v0, v10, new EdgeTuple("f", "f"));	
		Edge e19 = nounGraph.insertDirectedEdge(v10, v11, new EdgeTuple("i", "i"));
		Edge e20 = nounGraph.insertDirectedEdge(v11, v12, new EdgeTuple("n", "n"));
		Edge e21 = nounGraph.insertDirectedEdge(v12, v13, new EdgeTuple("c", "c"));
		Edge e22 = nounGraph.insertDirectedEdge(v13, v1, new EdgeTuple("h", "h"));
		
		Edge e23 = nounGraph.insertDirectedEdge(v0, v14, new EdgeTuple("g", "g"));
		Edge e24 = nounGraph.insertDirectedEdge(v14, v15, new EdgeTuple("o", "o"));		
		Edge e25 = nounGraph.insertDirectedEdge(v15, v16, new EdgeTuple("o", "o"));
		Edge e26 = nounGraph.insertDirectedEdge(v16, v17, new EdgeTuple("s", "s"));	
		Edge e27 = nounGraph.insertDirectedEdge(v17, v2, new EdgeTuple("e", "e"));
		
		Edge e28 = nounGraph.insertDirectedEdge(v0, v18, new EdgeTuple("g", "g"));	
		Edge e29 = nounGraph.insertDirectedEdge(v18, v19, new EdgeTuple("o", "e"));
		//Edge e30 = nounGraph.insertDirectedEdge(v18, v19, new EdgeTuple("e", "o"));
		Edge e31 = nounGraph.insertDirectedEdge(v19, v20, new EdgeTuple("o", "e"));
		//Edge e32 = nounGraph.insertDirectedEdge(v19, v20, new EdgeTuple("e", "o"));
		Edge e33 = nounGraph.insertDirectedEdge(v20, v21, new EdgeTuple("s", "s"));
		Edge e34 = nounGraph.insertDirectedEdge(v21, v3, new EdgeTuple("e", "e"));

//		System.out.println();
//		System.out.println("EDGES");
//		EdgeIterator ei = nounGraph.edges();
//		while (ei.hasNext())
//		{
//			System.out.println(ei.nextEdge());
//		}
//		
//		System.out.println();
//		System.out.println("VERTEXES");
//		VertexIterator vi = nounGraph.vertices();
//		while (vi.hasNext())
//		{
//			System.out.println(vi.nextVertex());
//		}
		
	}
	

	private void buildERuleGraph()
	{
		Vertex v0 	= eRuleGraph.insertVertex(0);
		Vertex v1 	= eRuleGraph.insertVertex(1);
		Vertex v2 	= eRuleGraph.insertVertex(2);
		Vertex v3 	= eRuleGraph.insertVertex(3);
		Vertex v4 	= eRuleGraph.insertVertex(4);
		Vertex v5 	= eRuleGraph.insertVertex(5);
		
		startEGV = v0;
		endEGV = v0;
		
		Edge e1 = eRuleGraph.insertDirectedEdge(v0, v1, new EdgeTuple("x", "x"));
		
		//Edge e2 = eRuleGraph.insertDirectedEdge(v1, v2, new EdgeTuple("^", ""));
		Edge e3 = eRuleGraph.insertDirectedEdge(v1, v2, new EdgeTuple("^s#", "es"));
		
		Edge e4 = eRuleGraph.insertDirectedEdge(v2, v0, new EdgeTuple("", "#"));		
		
		Edge e8 = eRuleGraph.insertDirectedEdge(v0, v5, new EdgeTuple("c", "c"));
		
		Edge e9 = eRuleGraph.insertDirectedEdge(v5, v1, new EdgeTuple("h", "h"));
		
		//OTHER#_
		String other = "abdefghijklmnopqrstuvwyz#";
		for(int i = 0; i < other.length(); i++)
		{
			String result = other.substring(i, i+1);
			eRuleGraph.insertDirectedEdge(v0, v0, new EdgeTuple(result, result));
		}
		
		//OTHER#_
		other = "abcdefgijklmnopqrstuvxwyz#";
		for(int i = 0; i < other.length(); i++)
		{
			String result = other.substring(i, i+1);
			eRuleGraph.insertDirectedEdge(v5, v0, new EdgeTuple(result, result));
		}
		
		//OTHER#_
		other = "abcdfghijklmnopqrstuvwyz#";
		for(int i = 0; i < other.length(); i++)
		{
			String result = other.substring(i, i+1);
			eRuleGraph.insertDirectedEdge(v1, v0, new EdgeTuple(result, result));
		}
		
		eRuleGraph.insertDirectedEdge(v0, v0, new EdgeTuple("ed#", "ed#"));
	}
	
}//end class


//System.out.println();
//System.out.println("v0:: " + v0);
//System.out.println("e:: " + e);
//
//System.out.println();
//System.out.println("e.element().toString():: " + e.element().toString());
//System.out.println("v0.element().toString():: " + v0.element().toString());
//
//System.out.println();
//System.out.println("e.element():: " + e.element());
//System.out.println("v0.element():: " + v0.element());
//
//EdgeTuple temp = (EdgeTuple)e.element();
//System.out.println();
//System.out.println("temp<.lhs> <- (EdgeTuple) e.element()):: " + temp.lhs);
//System.out.println("temp<.rhs> <- (EdgeTuple) e.element()):: " + temp.rhs);
//
//EdgeIterator ei = g.connectingEdges(v1, v5);
//System.out.println();
//System.out.println("EdgeIterator ei <- g.connectingEdges(v1, v5)::" );
//while (ei.hasNext())
//{
//	System.out.println("EdgeIterator ei.nextEdge():: " + ei.nextEdge());
//}
//
//ei = g.connectingEdges(v1, v5);
//System.out.println();
//System.out.println("EdgeIterator ei <- g.connectingEdges(v1, v5)::" );
//while (ei.hasNext())
//{
//	temp = (EdgeTuple)ei.nextEdge().element();
//	System.out.println("temp<.lhs> <- (EdgeTuple)ei.nextEdge().element():: " + temp.lhs);
//	System.out.println("temp<.rhs> <- (EdgeTuple)ei.nextEdge().element():: " + temp.rhs);
//}

