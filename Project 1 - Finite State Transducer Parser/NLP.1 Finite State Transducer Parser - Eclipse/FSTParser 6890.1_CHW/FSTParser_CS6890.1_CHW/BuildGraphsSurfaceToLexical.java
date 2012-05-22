import jdsl.graph.api.Graph;
import jdsl.graph.api.Vertex;
import jdsl.graph.ref.IncidenceListGraph;


public class BuildGraphsSurfaceToLexical 
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
	
	public BuildGraphsSurfaceToLexical ()
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
		
		pronounGraph.insertDirectedEdge(v0, v1, new EdgeTuple("i", ""));
		pronounGraph.insertDirectedEdge(v1, v5, new EdgeTuple("", "+prn"));
		pronounGraph.insertDirectedEdge(v5, v11, new EdgeTuple("#", "+1sg"));
		
		pronounGraph.insertDirectedEdge(v0, v12, new EdgeTuple("w", ""));	
		pronounGraph.insertDirectedEdge(v12, v2, new EdgeTuple("e", ""));
		pronounGraph.insertDirectedEdge(v2, v6, new EdgeTuple("", "+prn"));
		pronounGraph.insertDirectedEdge(v6, v11, new EdgeTuple("#", "+1pl"));
		
		pronounGraph.insertDirectedEdge(v0, v13, new EdgeTuple("h", ""));	
		pronounGraph.insertDirectedEdge(v13, v3, new EdgeTuple("e", ""));
		pronounGraph.insertDirectedEdge(v3, v7, new EdgeTuple("", "+prn"));
		pronounGraph.insertDirectedEdge(v7, v9, new EdgeTuple("", "+3sg"));
		pronounGraph.insertDirectedEdge(v9, v11, new EdgeTuple("#", "+musc"));
		
		pronounGraph.insertDirectedEdge(v0, v14, new EdgeTuple("s", ""));	
		pronounGraph.insertDirectedEdge(v14, v15, new EdgeTuple("h", ""));	
		pronounGraph.insertDirectedEdge(v15, v4, new EdgeTuple("e", ""));
		pronounGraph.insertDirectedEdge(v4, v8, new EdgeTuple("", "+prn"));
		pronounGraph.insertDirectedEdge(v8, v10, new EdgeTuple("", "+3sg"));
		pronounGraph.insertDirectedEdge(v10, v11, new EdgeTuple("#", "+fem"));
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
		
		verbGraph.insertDirectedEdge(v1, v4, new EdgeTuple("", "+v"));
		verbGraph.insertDirectedEdge(v2, v5, new EdgeTuple("", "+v"));
		verbGraph.insertDirectedEdge(v3, v6, new EdgeTuple("", "+v"));
		verbGraph.insertDirectedEdge(v9, v10, new EdgeTuple("", "+v"));
		verbGraph.insertDirectedEdge(v11, v12, new EdgeTuple("", "+v"));
		
		verbGraph.insertDirectedEdge(v4, v8, new EdgeTuple("ed#", "+past_form/past_part"));
		
		verbGraph.insertDirectedEdge(v6, v8, new EdgeTuple("#", "+past_form/past_part"));

		verbGraph.insertDirectedEdge(v10, v8, new EdgeTuple("#", "+past_form"));

		verbGraph.insertDirectedEdge(v12, v8, new EdgeTuple("#", "+past_part"));

		verbGraph.insertDirectedEdge(v5, v7, new EdgeTuple("", "+pres_form"));

		verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("^s#", "+3sg"));	
		verbGraph.insertDirectedEdge(v7, v8, new EdgeTuple("#", "+pl"));
		
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
		
		verbGraph.insertDirectedEdge(v0, v13, new EdgeTuple("b", "b"));
		verbGraph.insertDirectedEdge(v13, v14, new EdgeTuple("u", "u"));		
		verbGraph.insertDirectedEdge(v14, v15, new EdgeTuple("r", "r"));
		verbGraph.insertDirectedEdge(v15, v1, new EdgeTuple("n", "n"));
		
		verbGraph.insertDirectedEdge(v0, v16, new EdgeTuple("c", "c"));
		verbGraph.insertDirectedEdge(v16, v17, new EdgeTuple("a", "a"));
		verbGraph.insertDirectedEdge(v17, v18, new EdgeTuple("u", "t"));	
		verbGraph.insertDirectedEdge(v18, v19, new EdgeTuple("g", "c"));	
		verbGraph.insertDirectedEdge(v19, v20, new EdgeTuple("h", "h"));
		verbGraph.insertDirectedEdge(v20, v3, new EdgeTuple("t", ""));
		
		verbGraph.insertDirectedEdge(v0, v21, new EdgeTuple("f", "f"));
		verbGraph.insertDirectedEdge(v21, v22, new EdgeTuple("o", "o"));
		verbGraph.insertDirectedEdge(v22, v2, new EdgeTuple("x", "x"));		

		verbGraph.insertDirectedEdge(v0, v23, new EdgeTuple("s", "s"));
		verbGraph.insertDirectedEdge(v23, v24, new EdgeTuple("p", "p"));	
		verbGraph.insertDirectedEdge(v24, v25, new EdgeTuple("o", "e"));	
		verbGraph.insertDirectedEdge(v25, v26, new EdgeTuple("k", "a"));
		verbGraph.insertDirectedEdge(v26, v27, new EdgeTuple("e", "k"));
		verbGraph.insertDirectedEdge(v27, v9, new EdgeTuple("", ""));
		verbGraph.insertDirectedEdge(v27, v11, new EdgeTuple("n", ""));
		
		verbGraph.insertDirectedEdge(v0, v28, new EdgeTuple("s", "s"));	
		verbGraph.insertDirectedEdge(v28, v29, new EdgeTuple("a", "e"));	
		verbGraph.insertDirectedEdge(v29, v9, new EdgeTuple("w", "e"));
		
		verbGraph.insertDirectedEdge(v0, v30, new EdgeTuple("s", "s"));
		verbGraph.insertDirectedEdge(v30, v31, new EdgeTuple("e", "e"));
		verbGraph.insertDirectedEdge(v31, v32, new EdgeTuple("e", "e"));
		verbGraph.insertDirectedEdge(v32, v2, new EdgeTuple("", ""));
		verbGraph.insertDirectedEdge(v32, v33, new EdgeTuple("s", ""));
		verbGraph.insertDirectedEdge(v32, v11, new EdgeTuple("n", ""));

		verbGraph.insertDirectedEdge(v33, v34, new EdgeTuple("", "+v"));
		verbGraph.insertDirectedEdge(v34, v35, new EdgeTuple("", "+pres_form"));
		verbGraph.insertDirectedEdge(v35, v8, new EdgeTuple("#", "+3sg"));
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
		
		nounGraph.insertDirectedEdge(v1, v4, new EdgeTuple("", "+n"));
		nounGraph.insertDirectedEdge(v2, v5, new EdgeTuple("", "+n"));
		nounGraph.insertDirectedEdge(v3, v6, new EdgeTuple("", "+n"));

		nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("^s#", "+pl"));
		nounGraph.insertDirectedEdge(v4, v7, new EdgeTuple("#", "+sg"));
		
		nounGraph.insertDirectedEdge(v5, v7, new EdgeTuple("#", "+sg"));
		
		nounGraph.insertDirectedEdge(v6, v7, new EdgeTuple("#", "+pl"));

		
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
		
		nounGraph.insertDirectedEdge(v0, v8, new EdgeTuple("f", "f"));
		nounGraph.insertDirectedEdge(v8, v9, new EdgeTuple("o", "o"));	
		nounGraph.insertDirectedEdge(v9, v1, new EdgeTuple("x", "x"));
		
		nounGraph.insertDirectedEdge(v0, v10, new EdgeTuple("f", "f"));	
		nounGraph.insertDirectedEdge(v10, v11, new EdgeTuple("i", "i"));
		nounGraph.insertDirectedEdge(v11, v12, new EdgeTuple("n", "n"));
		nounGraph.insertDirectedEdge(v12, v13, new EdgeTuple("c", "c"));
		nounGraph.insertDirectedEdge(v13, v1, new EdgeTuple("h", "h"));
		
		nounGraph.insertDirectedEdge(v0, v14, new EdgeTuple("g", "g"));
		nounGraph.insertDirectedEdge(v14, v15, new EdgeTuple("o", "o"));		
		nounGraph.insertDirectedEdge(v15, v16, new EdgeTuple("o", "o"));
		nounGraph.insertDirectedEdge(v16, v17, new EdgeTuple("s", "s"));	
		nounGraph.insertDirectedEdge(v17, v2, new EdgeTuple("e", "e"));
		
		nounGraph.insertDirectedEdge(v0, v18, new EdgeTuple("g", "g"));	
		nounGraph.insertDirectedEdge(v18, v19, new EdgeTuple("e", "o"));
		nounGraph.insertDirectedEdge(v19, v20, new EdgeTuple("e", "o"));
		
		nounGraph.insertDirectedEdge(v20, v21, new EdgeTuple("s", "s"));
		nounGraph.insertDirectedEdge(v21, v3, new EdgeTuple("e", "e"));		
	}
	
	private void buildERuleGraph()
	{
		Vertex v0 	= eRuleGraph.insertVertex(0);
		Vertex v1 	= eRuleGraph.insertVertex(1);
		Vertex v2 	= eRuleGraph.insertVertex(2);
		Vertex v3 	= eRuleGraph.insertVertex(3);
		Vertex v4 	= eRuleGraph.insertVertex(4);
		
		startEGV = v0;
		endEGV = v0;
		
		eRuleGraph.insertDirectedEdge(v0, v1, new EdgeTuple("x", "x"));
		eRuleGraph.insertDirectedEdge(v1, v2, new EdgeTuple("e", "^"));
		eRuleGraph.insertDirectedEdge(v2, v3, new EdgeTuple("s", "s"));
		eRuleGraph.insertDirectedEdge(v3, v0, new EdgeTuple("#", "#"));
		eRuleGraph.insertDirectedEdge(v0, v4, new EdgeTuple("c", "c"));
		eRuleGraph.insertDirectedEdge(v4, v1, new EdgeTuple("h", "h"));
		
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
			eRuleGraph.insertDirectedEdge(v4, v0, new EdgeTuple(result, result));
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
