import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Questions {
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

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static int cheapestFlight(int flights[][], ArrayList<Edge> graph[], int src, int dest, int k) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,  0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                continue;
            }

            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.cost + 1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }
    public static void main(String[] args) {
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0;
        int dest = 3;
        int k = 1;
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, flights);
        System.out.println(cheapestFlight(flights, graph, src, dest, k));
    }
}
