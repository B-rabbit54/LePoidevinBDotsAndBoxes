package test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import main.BfsGraphTraversal;
import main.DfsGraphTraversal;
import main.DotsAndBoxes;
import main.Graph;

import org.junit.Test;

public class BoxTest {
//
//	@Test
//	public void BFSTest()
//	{
//		Graph g = new Graph(14);
//		g.addEdge(9, 5, 1);
//		g.addEdge(5, 7, 1);
//		g.addEdge(1, 7, 1);
//		g.addEdge(9, 1, 1);
//		g.addEdge(0, 8, 1);
//		BfsGraphTraversal bfs = new BfsGraphTraversal();
//		System.out.println("BreadthFS graph1: ");
//		List<List<Integer>> check = bfs.traverse(g);
//		System.out.println(check);
//		
////		Graph g2 = new Graph(14);
////		System.out.println("BreadthFS graph2: ");
////		List<List<Integer>> check2 = bfs.traverse(g2);
////		System.out.println(check2);
//	}
//	@Test
//	public void BFSTest2()
//	{
//		Graph g = new Graph(5);
//		g.addEdge(0, 1, 1);
//		g.addEdge(1, 4, 1);
//		g.addEdge(1, 2, 1);
//		g.addEdge(4, 2, 1);
//		g.addEdge(2, 3, 1);
//		g.addEdge(3, 2, 1);
//		BfsGraphTraversal bfs = new BfsGraphTraversal();
//		System.out.println("BreadthFS2 graph1: ");
//		List<List<Integer>> check = bfs.traverse(g);
//		System.out.println(check);
////		Graph g2 = new Graph(14);
////		System.out.println("BFS graph2: ");
////		List<List<Integer>> check2 = bfs.traverse(g2);
//	}
//	
//	@Test
//	public void DFSTest()
//	{
//		Graph g = new Graph(14);
//		g.addEdge(4, 7, 1);
//		g.addEdge(5, 7, 1);
//		g.addEdge(7, 1, 1);
//		g.addEdge(9, 1, 1);
//		g.addEdge(0, 1, 1);
//		g.addEdge(10, 11, 1);
//		DfsGraphTraversal dfs = new DfsGraphTraversal();
//		System.out.println("DepthFS graph1: ");
//		List<List<Integer>> check = dfs.traverse(g);
//		System.out.println(check);
////		Graph g2 = new Graph(14);
////		System.out.println("DepthFS graph2: ");
////		List<List<Integer>> check2 = dfs.traverse(g2);
////		System.out.println(check2);
//		
//	}
//	@Test
//	public void DFSTest2()
//	{
//		Graph g = new Graph(5);
//		g.addEdge(0, 1, 1);
//		g.addEdge(1, 4, 1);
//		g.addEdge(4, 2, 1);
//		g.addEdge(2, 3, 1);
//		g.addEdge(3, 2, 1);
//		DfsGraphTraversal dfs = new DfsGraphTraversal();
//		System.out.println("DepthFS2 graph1: ");
//		List<List<Integer>> check = dfs.traverse(g);
//		System.out.println(check);
//	}

//	@Test
//	public void boardCreation()
//	{
//		DotsAndBoxes game = new DotsAndBoxes(5,5);
//		DfsGraphTraversal dfs = new DfsGraphTraversal();
//		System.out.println("DepthFS2 graph1: ");
//		List<List<Integer>> check = dfs.traverse(game.getBoard());
//		System.out.println(check);
//	}
	@Test
	public void dotsCreation()
	{
		DotsAndBoxes game = new DotsAndBoxes(4,4);
	}
	@Test
	public void noMovesLeft()
	{
		DotsAndBoxes game = new DotsAndBoxes(2,2);
		game.drawLine(1, 0, 0, 0, 1);
		game.drawLine(1, 0, 1, 1, 1);
		game.drawLine(1, 0, 0, 1, 0);
		game.drawLine(1, 1, 0, 1, 1);
		assertFalse(game.areMovesLeft());
	}
	@Test
	public void OneBoxTest() {
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 1, 0, 2, 0);
		//d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 1, 2, 1);
		//d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 0, 1, 1);
		//d.drawLine(1, 3, 0, 3, 1);
		

		d.drawLine(1, 2, 0, 2, 1); // draw line in between a double-cross
		System.out.println("Player one score: " + d.score(1));
	//	d.printBoardArray();
		assertEquals(1, d.score(1));
	}
	
	
	@Test
	public void testOwner() {
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 1, 0, 2, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 1, 2, 1);
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 0, 1, 1);
		d.drawLine(1, 3, 0, 3, 1);
		
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		d.drawLine(1, 1, 2, 1, 3);
		d.drawLine(1, 1, 3, 1, 4);
		d.drawLine(1, 0, 2, 1, 2);
		d.drawLine(1, 0, 4, 1, 4);

		d.drawLine(1, 2, 0, 2, 1); // draw line in between a double-cross
		System.out.println("Player one score: " + d.score(1));
	//	d.printBoardArray();
		assertEquals(2, d.score(1));
	}
	
	@Test
	public void testDoubleCrosses() {
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		d.drawLine(1, 1, 0, 2, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 1, 2, 1);
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 0, 1, 1);
		d.drawLine(1, 3, 0, 3, 1);
		
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		d.drawLine(1, 1, 2, 1, 3);
		d.drawLine(1, 1, 3, 1, 4);
		d.drawLine(1, 0, 2, 1, 2);
		d.drawLine(1, 0, 4, 1, 4);
		
		//Assert.assertEquals(2, d.countDoubleCrosses());
	}
	
	@Test
	public void testCycle() {
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
//		.-.-.-.-.
//		|       |
//		. .-.-. .
//		| |   | |
//		. . . . .
//		| |   | |
//		. .-.-. .
//		|       |
//		.-.-.-.-.
		
		d.drawLine(1, 0, 0, 0, 1);
		d.drawLine(1, 0, 1, 0, 2);
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		
		d.drawLine(1, 0, 4, 1, 4);
		d.drawLine(1, 1, 4, 2, 4);
		d.drawLine(1, 2, 4, 3, 4);
		d.drawLine(1, 3, 4, 4, 4);
		
		d.drawLine(1, 4, 3, 4, 4);
		d.drawLine(1, 4, 2, 4, 3);
		d.drawLine(1, 4, 1, 4, 2);
		d.drawLine(1, 4, 0, 4, 1);
		
		d.drawLine(1, 3, 0, 4, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 0, 2, 0);
		d.drawLine(1, 0, 0, 1, 0);
		
		d.drawLine(1, 1, 1, 1, 2);
		d.drawLine(1, 1, 2, 1, 3);
		
		d.drawLine(1, 1, 3, 2, 3);
		d.drawLine(1, 2, 3, 3, 3);
		
		d.drawLine(1, 3, 2, 3, 3);
		d.drawLine(1, 3, 1, 3, 2);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
		Assert.assertEquals(2, d.countCycles());
	}

	@Test
	public void testChains() {
		
//		. . .-.-.
//		| |     |
//		. .-.-. .
//		| |   | |
//		. . . . .
//		| |   | |
//		. .-.-. .
//		|       |
//		.-.-.-.-.
		
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 0, 0, 0, 1);
		d.drawLine(1, 0, 1, 0, 2);
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		
		d.drawLine(1, 0, 4, 1, 4);
		d.drawLine(1, 1, 4, 2, 4);
		d.drawLine(1, 2, 4, 3, 4);
		d.drawLine(1, 3, 4, 4, 4);
		
		d.drawLine(1, 4, 3, 4, 4);
		d.drawLine(1, 4, 2, 4, 3);
		d.drawLine(1, 4, 1, 4, 2);
		d.drawLine(1, 4, 0, 4, 1);
		
		d.drawLine(1, 3, 0, 4, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 0, 1, 1);
		
		d.drawLine(1, 1, 1, 1, 2);
		d.drawLine(1, 1, 2, 1, 3);
		
		d.drawLine(1, 1, 3, 2, 3);
		d.drawLine(1, 2, 3, 3, 3);
		
		d.drawLine(1, 3, 2, 3, 3);
		d.drawLine(1, 3, 1, 3, 2);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
	//	Assert.assertEquals(1, d.countOpenChains());		
	}
	
	@Test
	public void testTwoChains() {
		
//		. . .-.-.
//		| |     |
//		. .-.-. .
//		| |   | |
//		. . . . .
//		| |   | |
//		. .-.-. .
//		|   |   |
//		.-. . .-.
		
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 0, 0, 0, 1);
		d.drawLine(1, 0, 1, 0, 2);
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		
		d.drawLine(1, 0, 4, 1, 4);
		d.drawLine(1, 2, 3, 2, 4);
		d.drawLine(1, 3, 4, 4, 4);
		
		d.drawLine(1, 4, 3, 4, 4);
		d.drawLine(1, 4, 2, 4, 3);
		d.drawLine(1, 4, 1, 4, 2);
		d.drawLine(1, 4, 0, 4, 1);
		
		d.drawLine(1, 3, 0, 4, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 0, 1, 1);
		
		d.drawLine(1, 1, 1, 1, 2);
		d.drawLine(1, 1, 2, 1, 3);
		
		d.drawLine(1, 1, 3, 2, 3);
		d.drawLine(1, 2, 3, 3, 3);
		
		d.drawLine(1, 3, 2, 3, 3);
		d.drawLine(1, 3, 1, 3, 2);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
		Assert.assertEquals(2, d.countOpenChains());		
	}

	@Test
	public void testInternalChains() {
		
//		.-.-.-.-.
//		|       |
//		. .-.-. .
//		| |     |
//		. . .-. .
//		| |     |
//		. .-.-. .
//		|       |
//		.-.-.-.-.
		
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 0, 0, 0, 1);
		d.drawLine(1, 0, 1, 0, 2);
		d.drawLine(1, 0, 2, 0, 3);
		d.drawLine(1, 0, 3, 0, 4);
		
		d.drawLine(1, 0, 4, 1, 4);
		d.drawLine(1, 1, 4, 2, 4);
		d.drawLine(1, 2, 4, 3, 4);
		d.drawLine(1, 3, 4, 4, 4);
		
		d.drawLine(1, 4, 3, 4, 4);
		d.drawLine(1, 4, 2, 4, 3);
		d.drawLine(1, 4, 1, 4, 2);
		d.drawLine(1, 4, 0, 4, 1);
		
		d.drawLine(1, 3, 0, 4, 0);
		d.drawLine(1, 2, 0, 3, 0);
		d.drawLine(1, 1, 0, 2, 0);
		d.drawLine(1, 0, 0, 1, 0);
		
		d.drawLine(1, 1, 1, 1, 2);
		d.drawLine(1, 1, 2, 1, 3);
		
		d.drawLine(1, 1, 3, 2, 3);
		d.drawLine(1, 2, 3, 3, 3);
		
		d.drawLine(1, 2, 2, 3, 2);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
		Assert.assertEquals(2, d.countOpenChains());		
	}

	@Test
	public void testInternalChain() {
		
//		. . . . .
//		
//		. .-.-. .
//		  |     
//		. . ._. .
//		  |     
//		. .-.-. .
//		       
//		. . . . .
		
		DotsAndBoxes d = new DotsAndBoxes(5, 5);
		
		d.drawLine(1, 1, 1, 1, 2);
		d.drawLine(1, 1, 2, 1, 3);
		
		d.drawLine(1, 1, 3, 2, 3);
		d.drawLine(1, 2, 3, 3, 3);
		
		d.drawLine(1, 2, 2, 3, 2);
		d.drawLine(1, 3, 2, 3, 3);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
		Assert.assertEquals(1, d.countOpenChains());		
	}

	@Test
	public void testNotAChain() {
		
//		. . . . .
//		
//		. .-.-. .
//		       
//		. ._._. .
//		      
//		. . . . .
//		       
//		. . . . .
		
		DotsAndBoxes d = new DotsAndBoxes(5, 5);

		d.drawLine(1, 1, 2, 2, 2);
		d.drawLine(1, 2, 2, 3, 2);
		
		d.drawLine(1, 2, 1, 3, 1);
		d.drawLine(1, 1, 1, 2, 1);
		
		Assert.assertEquals(0, d.countOpenChains());		
		Assert.assertEquals(0, d.countCycles());
		Assert.assertEquals(0, d.countDoubleCrosses());
	}

}
