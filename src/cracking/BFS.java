package cracking;
import java.io.*;
import java.util.*;

public class BFS {
	/*
	 * Consider an undirected graph consisting of n nodes where each node is labeled from 1
	 * to n and the edge between any two nodes is always of length 6.
	 * We define node s to be the starting position for a BFS.
	 * 
	 * Given q queries in the form of a graph and some starting node, s, perform each query by 
	 * calculating the shortest distance from starting node s to all the other nodes in the graph. 
	 * Then print a single line of n-1 space-separated integers listing node s's shortest distance 
	 * to each of the n-1 other nodes (ordered sequentially by node number);
	 * if s is disconnected from a node, print -1 as the distance to that node.
	 */
	
	/*
	 * Input format:
	 * The first line contains an integer, q, denoting the number of queries. 
	 * The subsequent lines describe each query in the following format:
	 * 	  -The first line contains two space-separated integers describing the respective values of 
	 * n (the number of nodes) and  m (the number of edges) in the graph.
	 * 	  -Each line i of the m subsequent lines contains two space-separated integers, u and v,
	 * describing an edge connecting node u to node v.
	 *    -The last line contains a single integer, s, denoting the index of the starting node.
	 */
	
	/*
	 * Output format:
	 * For each of the  queries, print a single line of n-1 space-separated integers denoting the 
	 * shortest distances to each of the n-1 other nodes from starting position s. 
	 * These distances should be listed sequentially by node number (i.e., 1,2,...n), 
	 * but should not include node s. 
	 * If some node is unreachable from s, print -1 as the distance to that node.
	 */
	
	private static final int EDGE_WEIGHT = 6;
	
    public static void main(String[] args) {
    		Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();
        
        for (int q = 0; q < numQueries; q++) {
            int numNodes = scan.nextInt();
            int numEdges = scan.nextInt();
            
            /* Create Nodes */
            Node [] node = new Node[numNodes + 1]; // node "i" will be at index "i"
            node[0] = null;
            for (int i = 1; i <= numNodes; i++) {
                node[i] = new Node(i);
            }
            
            /* Connect Nodes */
            for (int i = 0; i < numEdges; i++) {
                int n1 = scan.nextInt();
                int n2 = scan.nextInt();
                node[n1].addNeighbor(node[n2]);
            }
            
            /* Create MST */
            int start = scan.nextInt();
            findDistances(node[start]);

            /* Print results */
            for (int i = 1; i <= numNodes; i++) {
                if (i != start) {
                    System.out.print(node[i].distance + " ");
                }
            }
            System.out.println();
        }
        scan.close();
    }
    
    public static void findDistances(Node start) {
    		if(start == null) {
    			return;
    		}
    		
    		ArrayDeque<Node> q = new ArrayDeque<Node>();
    		start.distance = 0;
    		q.add(start);
    		
    		while(!q.isEmpty()) {
    			Node curr = q.pop();
    			for(Node n:curr.neighbors) {
    				if(n.distance == -1) {
	    				n.distance = curr.distance + EDGE_WEIGHT;
	    				q.add(n);
	    			}
    			}
    		}
    	
    }
    
    public static class Node{
    		public final int id;
    		public int distance;
    		public HashSet<Node> neighbors;
    		
    		public Node(int num) {
    			this.id=num;
    			this.distance = -1;
    			this.neighbors = new HashSet<Node>();
    		}
    		
    		public void addNeighbor(Node n) {
    			this.neighbors.add(n);
    			n.neighbors.add(this);
    		}
    		
    		@Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            } else if (other == null || !(other instanceof Node)) {
                return false;
            }
            Node otherNode = (Node) other;
            return this.id == otherNode.id;
        }

        @Override
        public int hashCode() {
            return id; // simple and effective
        }
    }

}
