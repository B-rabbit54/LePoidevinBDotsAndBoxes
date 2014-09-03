package main;

import java.util.ArrayList;
import java.util.List;

public class DfsGraphTraversal {
	
//	** Depth first search */
//	static void DFS(Graph G, int v) {
//	PreVisit(G, v); // Take appropriate action
//	G.setMark(v, VISITED);
//	for (int w = G.first(v); w < G.n() ; w = G.next(v, w))
//	if (G.getMark(w) == UNVISITED)
//	DFS(G, w);
//	PostVisit(G, v); // Take appropriate action
//	}

	
	List<List<Integer>> vertexConnectionsList;
	List<Integer> List;
	private final int VISITED = 1;
	private final int UNVISITED = 0;
	public List<List<Integer>> traverse(Graph g)  // returns all the connected components of a graph, listed in their order of visitation
	{
		vertexConnectionsList = new ArrayList<List<Integer>>();

		for (int i = 0; i < g.vcount(); i++)
		{
			List = new ArrayList<Integer>();
			if(g.getMark(i) == UNVISITED)
			vertexConnectionsList.add(DFS(g, i));
		}
		return vertexConnectionsList;
	}
	
	private void PreVisit(Graph g, int v)
	{
		
			ArrayList<Integer> valueList = new ArrayList<Integer>();
			valueList.add(v);
			for (int j = 0; j < g.vcount(); j++)
			{	
				if(g.isEdge(v, j))
				{
					valueList.add(j);
				}
			}
			vertexConnectionsList.add(valueList);
	}
	
	private List<Integer> DFS(Graph G, int v)
	{			
		//PreVisit(G, v); // Take appropriate action
		G.setmark(v, VISITED);
		for (int w = G.first(v); w < G.vcount(); w = G.next(v, w))
		if (G.getMark(w) == UNVISITED)
		{
			DFS(G, w);
		}
		PostVisit(G, v); // Take appropriate action
		return List;
		
	}
	
	private void PostVisit(Graph g, int v)
	{
		System.out.println("Vertex: " + v);
		List.add(v);
	}
	
}
