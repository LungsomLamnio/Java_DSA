package Graphs;
import java.util.*;

public class GraphClassroom {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[1].add(new Edge(4, 2, 1));
        graph[1].add(new Edge(4, 3, 1));
        graph[1].add(new Edge(4, 5, 1));

        graph[1].add(new Edge(5, 3, 1));
        graph[1].add(new Edge(5, 4, 1));
        graph[1].add(new Edge(5, 6, 1));

        graph[1].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean isVisited[]) {
        System.out.print(curr + " ");
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]) {
                dfsUtil(graph, e.dest, isVisited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean isVisited[], int src, int dest) {
        if(src == dest) {
            return true;
        }

        isVisited[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!isVisited[e.dest] && hasPath(graph, isVisited, e.dest, dest)) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(hasPath(graph, new boolean[V], 0, 5));
    }
}
