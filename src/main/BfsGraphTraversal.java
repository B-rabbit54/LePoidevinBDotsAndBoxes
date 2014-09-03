package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraphTraversal {
	List<List<Integer>> vertexConnectionsList;
	private final int VISITED = 1;
	private final int UNVISITED = 0;
	
	
	public List<List<Integer>> traverse(Graph g)  // returns all the connected components of a graph, listed in their order of visitation
	{
		vertexConnectionsList = new ArrayList<List<Integer>>();

		for (int i = 0; i < g.vcount(); i++)
		{
			if(g.getMark(i) == UNVISITED)
			{
				vertexConnectionsList.add(BFS(g, i));
			}
//			else
//			{
//				System.out.println("Did not visit: " + i);
//			}
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
	
	private List<Integer> BFS(Graph G, int start)
	{
		List<Integer> list = new LinkedList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		G.setmark(start, 1);
		while(queue.size() > 0)
		{
			int v = queue.poll();
			//previsit(G, v);
			for(int w = G.first(v); w < G.vcount(); w = G.next(v, w))
			{
				if(G.getMark(w) == UNVISITED)
				{
					G.setmark(w, VISITED);
					queue.add(w);
				}			
			}
			PostVisit(G, v, list);
		}
		return list;
		
	}
//	/** Breadth first (queue-based) search */
//	static void BFS(Graph G, int start) {
//	Queue<Integer> Q = new AQueue<Integer>(G.n());
//	Q.enqueue(start);
//	G.setMark(start, VISITED);
//	while (Q.length() > 0) { // Process each vertex on Q
//	int v = Q.dequeue();
//	PreVisit(G, v); // Take appropriate action
//	for (int w = G.first(v); w < G.n(); w = G.next(v, w))
//	if (G.getMark(w) == UNVISITED) { // Put neighbors on Q
//	G.setMark(w, VISITED);
//	Q.enqueue(w);
//	}
//	PostVisit(G, v); // Take appropriate action
//	}
//	}
	private void PostVisit(Graph g, int v, List<Integer> list)
	{
		////System.out.println("Visisted: " + v);
		list.add(v);
	}
	

}
