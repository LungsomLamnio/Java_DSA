import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PracticeQuestion {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(2, 9));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 5));

        graph[4].add(new Edge(4, 2));

        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 9));

        graph[9].add(new Edge(9, 1));
        graph[9].add(new Edge(9, 5));
    }

    public static boolean detectCycleInUndirectedGraphUsingBFS(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!isVisited[curr]) {
                isVisited[curr] = true;

                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);

                    if(isVisited[e.dest]) {
                        return false;
                    }
                    q.add(e.dest);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycleInUndirectedGraphUsingBFS(graph));
    }
}
