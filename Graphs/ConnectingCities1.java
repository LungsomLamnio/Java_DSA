import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities1 {
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
    public static void createGraph(ArrayList<Edge> graph[], int cities[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cities.length; i++) {
            for(int j=0; j<cities[i].length; j++) {
                if(i != j && cities[i][j] > 0) {
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
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

    public static int connectingCitiesWithMinimumCost(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int cost = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!isVisited[curr.vertex]) {
                isVisited[curr.vertex] = true;
                cost += curr.cost;
                for(int i=0; i<graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        return cost;
    }
    public static void main(String[] args) {
        int cities[][] = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        int V = cities.length;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, cities);
        System.out.println(connectingCitiesWithMinimumCost(graph));
    }
}
