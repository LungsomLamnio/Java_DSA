package Graphs;

import java.util.*;

public class DFS {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor
    public DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS traversal from a given source node
    private void DFSUtil(int node, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFS(int startNode) {
        boolean visited[] = new boolean[V]; // Track visited nodes
        DFSUtil(startNode, visited);
    }

    public static void main(String args[]) {
        DFS g = new DFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        
        System.out.println("Depth-First Search (starting from node 0):");
        g.DFS(0);
    }
}
