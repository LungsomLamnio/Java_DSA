import java.util.ArrayList;
import java.util.Stack;

public class HasPath {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean isVisited[]) {
        if(src == dest) {
            return true;
        }

        isVisited[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!isVisited[e.dest]) {
                if(hasPath(graph, e.dest, dest, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean cycleDetectionInDirectedGraph(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(cycleDetectionInDirectedGraphUtil(graph, isVisited, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionInDirectedGraphUtil(ArrayList<Edge> graph[], boolean isVisited[], boolean stack[], int curr) {
        isVisited[curr] = true;
        stack[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            
            if(stack[e.dest]) {
                return true;
            }

            if(!isVisited[e.dest]) {
                if(cycleDetectionInDirectedGraphUtil(graph, isVisited, stack, e.dest)) {
                    return true;
                }
            }
        }
        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(cycleDetectionInDirectedGraph(graph));
    }
}
