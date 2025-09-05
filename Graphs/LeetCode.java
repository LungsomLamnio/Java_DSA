import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode {
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

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    static class Info {
        int vertex;
        int cost;
        int k;

        public Info(int vertex, int cost, int k) {
            this.vertex = vertex;
            this.cost = cost;
            this.k = k;
        }
    }

    public static int cheapestFlightWithinKStop(ArrayList<Edge> graph[], int src, int dest, int k) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean isVisited[] = new boolean[graph.length];
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.vertex <= k) {
                for(int i=0; i<graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        q.add(new Info(v, dist[v], k++));
                    }
                }
            }
        }

        if(dist[dest] != Integer.MAX_VALUE) {
            return dist[dest];
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
       
    }
}
