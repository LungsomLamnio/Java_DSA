import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                bfsUtil(graph, isVisited, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean isVisited[], int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);

        while(!q.isEmpty()) {
            int currNode = q.remove();
            
            if(!isVisited[currNode]) {
                isVisited[currNode] = true;
                System.out.print(currNode + " ");

                for(int i=0; i<graph[currNode].size(); i++) {
                    Edge e = graph[currNode].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                dfsUtil(graph, isVisited, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean isVisited[], int curr) {
        isVisited[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]) {
                dfsUtil(graph, isVisited, e.dest);
            }
        }
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

    public static boolean detectCycleUndirected(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(detectCycleUndirectedUtil(graph, i, -1, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUndirectedUtil(ArrayList<Edge> graph[], int curr, int par, boolean isVisited[]) {
        isVisited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]) {
                if(detectCycleUndirectedUtil(graph, e.dest, curr, isVisited)) {
                    return true;
                }
            } else if(isVisited[e.dest] && e.dest != par) {
                    return true;
                }
            }
        return false;
    }

    // public static boolean isBipartite(ArrayList<Edge> graph[]) {
    //     int color[] = new int[graph.length];
    //     for(int i=0; i<graph.length; i++) {
    //         color[i] = -1;
    //     }

    //     Queue<Integer> q = new LinkedList<>();

    //     for(int i=0; i<graph.length; i++) {
    //         if(color[i] == -1) {
    //             color[i] = 0;

    //             q.add(i);

    //             while(!q.isEmpty()) {
    //                 int curr = q.remove();
    //                 for(int j=0; j<graph[curr].size(); j++) {
    //                     Edge e = graph[curr].get(j);

    //                     if(color[e.dest] == -1) {
    //                         int nextColor = color[curr] == 0 ? 1 : 0;
    //                         color[e.dest] = nextColor;
    //                         q.add(e.dest);
    //                     } else if(color[e.dest] == color[curr]) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                q.add(i);

                while(!q.isEmpty()) {
                    int curr = q.remove();

                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (color[curr] == color[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
     }

     public static boolean detectCycleDirected(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(detectCycleDirectedUtil(graph, i, isVisited, stack)) {
                    return true;
                }
            }
        }
        return false;
     }

     public static boolean detectCycleDirectedUtil(ArrayList<Edge> graph[], int curr, boolean isVisited[], boolean stack[]) {
        isVisited[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.dest]) {
                return true;
            } else if(!isVisited[e.dest]) {
                if(detectCycleDirectedUtil(graph, e.dest, isVisited, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
     }

     public static void topSort(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                topSortUtil(graph, i, isVisited, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
     }

     public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean isVisited[], Stack<Integer> s) {
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]) {
                topSortUtil(graph, e.dest, isVisited, s);
            }
        }
        s.push(curr);
    }

    public static void calIndegree(ArrayList<Edge> graph[], int inDegree[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest] += 1;
            }
        }
    }

    public static void kahnsAlgo(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[graph.length];
        calIndegree(graph, inDegree);

        for(int i=0; i<graph.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path+dest);
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path+src);
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean isVisited[] = new boolean[graph.length];
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!isVisited[curr.node]) {
                isVisited[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0);
    }
}
