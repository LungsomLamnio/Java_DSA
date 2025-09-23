import java.util.*;

public class KosarajuAlgorithm {
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
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean isVisited[], Stack<Integer> s) {
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]) {
                topSort(graph, e.dest, isVisited, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean isVisited[]) {
        isVisited[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]) {
                dfs(graph, e.dest, isVisited);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                topSort(graph, i, isVisited, s);
            }
        }

        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++) {
            isVisited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!isVisited[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, isVisited);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph);
    }
}
