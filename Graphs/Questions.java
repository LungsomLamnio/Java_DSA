import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
        int city;
        int cost;
        int stops;

        public Info(int city, int cost, int stops) {
            this.city = city;
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

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                continue;
            }

            for(int i=0; i<graph[curr.city].size(); i++) {
                Edge e = graph[curr.city].get(i);
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
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
        int n = 4;
        int flights[][] = {
            {0,1,100},
            {1,2,100},
            {2,0,100},
            {1,3,600},
            {2,3,200},
        };
        int src = 0;
        int dest = 3;
        int k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}