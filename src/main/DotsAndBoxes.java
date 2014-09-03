package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DotsAndBoxes {
	
	Graph board;
	Dot[][] dots;
	int weight = 0;
	int rows;
	int colums;
	int graphRows;
	int graphColums;
	int totalGraphVerticies;
	int [] players = new int [3];
	public DotsAndBoxes(int rows, int columns)
	{
		dots = new Dot[rows][columns];
		this.rows = rows;
		this.colums = columns;
		graphRows = rows + 1;
		graphColums = columns + 1;
		totalGraphVerticies = graphRows * graphColums;
		board = new Graph(totalGraphVerticies);
		SetUpGraph();
		SetUpDots();
	}
	public Graph getBoard()
	{
		return board;
	}
	private void SetUpGraph()
	{
		for (int i = 1; i < (graphColums-1); i++)
		{
			for (int j = 1; j < (graphRows - 1); j++)
			{
				int vertex = (i * graphRows) + j;
				int aboveVertex = vertex - graphRows;
				int rightVertex = vertex + 1;
				int belowVertex = vertex + graphRows;
				int leftVertex = vertex - 1;
				board.addEdge(vertex, aboveVertex, 1);
				board.addEdge(vertex, rightVertex, 1);
				board.addEdge(vertex, belowVertex, 1);
				board.addEdge(vertex, leftVertex, 1);
			}
		}
	}
	private void SetUpDots()
	{
		for(int c = 0; c < colums; c++)
		{
			for(int r = 0; r < rows; r++)
			{
				Dot dot = new Dot();
				int topLeft = (c*graphRows)+ r;
				int topRight = topLeft + 1;
				int bottomLeft = topLeft + (graphRows);
				int bottomRight = topRight + (graphRows);
				dot.setTopLeft(topLeft);
				dot.setTopRight(topRight);
				dot.setBottomLeft(bottomLeft);
				dot.setBottomRight(bottomRight);
				dots[r][c] = dot;
			}
		}
	}
	
	
	public int drawLine(int player, int x1, int y1, int x2, int y2) // draws a line on the Dots and Boxes board, returns how many boxes were completed by drawing the line.
	{
		int completed = 0;
		Dot dot1 = dots[x1][y1];
		Dot dot2 = dots[x2][y2];
		if(x2 - x1 == 0)
		{//vertical line
			if(dot1.getBottomLeft() == dot2.getTopLeft() && dot1.getBottomRight() == dot2.getTopRight())
			{// down
				board.removeEdge(dot1.getBottomLeft(), dot1.getBottomRight());
				if(x1 == 0)
				{
					if(BFSBoxComplete(board, dot1.getBottomRight()).size() == 1)
					{
						completed++;
					}
				}
				else if(x1 == (rows - 1))
				{
					if(BFSBoxComplete(board, dot1.getBottomLeft()).size() == 1)
					{
						completed++;
					}
				}
				else
				{
					if(BFSBoxComplete(board, dot1.getBottomRight()).size() == 1)
					{
						completed++;
					}
					board.resetMarks();
					if(BFSBoxComplete(board, dot1.getBottomLeft()).size() == 1)
					{
						completed++;
					}
					
				}
			}
			else if(dot1.getTopRight() == dot2.getBottomRight() && dot1.getTopLeft() == dot2.getBottomLeft())
			{// ^ up
				board.removeEdge(dot1.getTopRight(), dot1.getTopLeft());
				if(x1 == 0)
				{
					if(BFSBoxComplete(board, dot1.getTopRight()).size() == 1)
					{
						completed++;
					}
				}
				else if(x1 == (rows - 1))
				{
					if(BFSBoxComplete(board, dot1.getTopLeft()).size() == 1)
					{
						completed++;
					}
				}
				else
				{
					if(BFSBoxComplete(board, dot1.getTopRight()).size() == 1)
					{
						completed++;
					}
					if(BFSBoxComplete(board, dot1.getTopLeft()).size() == 1)
					{
						completed++;
					}
					
				}
			}
			
		}
		else if(y2 - y1 == 0)
		{//horizontal line
			if(dot1.getTopRight() == dot2.getTopLeft() && dot1.getBottomRight() == dot2.getBottomLeft())
			{// > right
				board.removeEdge(dot1.getTopRight(), dot1.getBottomRight());
				if(y1 == 0)
				{
					if(BFSBoxComplete(board, dot1.getBottomRight()).size() == 1)
					{
						completed++;
					}
				}
				else if(y1 == (colums - 1))
				{
					if(BFSBoxComplete(board, dot1.getTopRight()).size() == 1)
					{
						completed++;
					}
				}
				else
				{
					if(BFSBoxComplete(board, dot1.getTopRight()).size() == 1)
					{
						completed++;
					}
					board.resetMarks();
					if(BFSBoxComplete(board, dot1.getBottomRight()).size() == 1)
					{
						completed++;
					}
				}
			}
			else if(dot1.getTopLeft() == dot2.getTopRight() && dot1.getBottomLeft() == dot2.getBottomRight())
			{// < left
				board.removeEdge(dot1.getTopLeft(), dot1.getBottomLeft());
				if(y1 == 0)
				{
					if(BFSBoxComplete(board, dot1.getBottomLeft()).size() == 1)
					{
						completed++;
					}
				}
				else if(y1 == (colums - 1))
				{
					if(BFSBoxComplete(board, dot1.getTopLeft()).size() == 1)
					{
						completed++;
					}
				}
				else
				{
					if(BFSBoxComplete(board, dot1.getTopLeft()).size() == 1)
					{
						completed++;
					}
					board.resetMarks();
					if(BFSBoxComplete(board, dot1.getBottomLeft()).size() == 1)
					{
						completed++;
					}
				}
			}
		}
		players[player]+= completed;
		board.resetMarks();
		return completed;
	} 
	private List<Integer> BFSBoxComplete(Graph G, int start)
	{
		int UNVISITED = 0;
		int VISITED = 1;
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
	private void PostVisit(Graph g, int v, List<Integer> list)
	{
		//System.out.println("Visisted: " + v);
		list.add(v);
	}

	public int score(int player)// returns the number of boxes the player has completed 
	{
		return players[player];
	} 

	public boolean anyMovesLeft() // returns whether the Dots and Boxes board is full.
	{
		BfsGraphTraversal travers = new BfsGraphTraversal();
		if(travers.traverse(board).size() == totalGraphVerticies)
		{
			board.resetMarks();
			return false;
		}
		else 
		{
			board.resetMarks();
			return true;
		}
	} 
	public boolean areMovesLeft() {// returns whether or not there are any lines to be drawn
		BfsGraphTraversal travers = new BfsGraphTraversal();
		if(travers.traverse(board).size() == totalGraphVerticies)
		{
			board.resetMarks();
			return false;
		}
		else 
		{
			board.resetMarks();
			return true;
		}
	} 
	public int countDoubleCrosses() {
		int count = 0;
		BfsGraphTraversal travers = new BfsGraphTraversal();
		List<List<Integer>> check = travers.traverse(board);
		for(List<Integer> list : check)
		{
			if(list.size() == 2)
			{
				count++;
			}
		}
		
		return count;
	} // returns the number of double-crosses on the board
	public int countCycles() {
		int count = 0;
		BfsGraphTraversal travers = new BfsGraphTraversal();
		List<List<Integer>> check = travers.traverse(board);
		board.resetMarks();
		for(List<Integer> list : check)
		{
			if(list.size() > 2)
			{
				if(isCycle(list))
				{
					count++;
				}
			}
		}
		
		return count;
	} // returns the number of cycles on the board
	
	public boolean isCycle(List<Integer> list)
	{
		int startingVertex = list.get(0);
		int lastVertex = list.get(list.size()-1);
		
		//int next = board.next(lastVertex, 0);
		
		for(int i = 1; i < list.size(); i++)
		{
			int vertex = list.get(i);
			int next = board.next(vertex, 0);
			if(next == startingVertex)
			{
				return true;
			}
		}	
		
		return false;
	}
	
	
	public int countOpenChains() {
		int count = 0;
		BfsGraphTraversal travers = new BfsGraphTraversal();
		List<List<Integer>> check = travers.traverse(board);
		for(List<Integer> list : check)
		{
			if(list.size() > 2)
			{
				count++;
			}
		}
		return count;
	}  // returns the number of open chains on the board
	public void printBoardArray() {
		DfsGraphTraversal dfs = new DfsGraphTraversal();
		List<List<Integer>> check = dfs.traverse(board);
		System.out.println(check);
		// TODO Auto-generated method stub
		
	}


}
