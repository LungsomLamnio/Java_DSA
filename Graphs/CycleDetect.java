import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CycleDetect {
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
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(detectCycleUtil(graph, isVisited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean isVisited[], int curr, int par) {
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case 1
            if(!isVisited[e.dest]) {
                if(detectCycleUtil(graph, isVisited, e.dest, curr)) {
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
    //             q.add(i);
    //             color[i] = 0;

    //             while(!q.isEmpty()) {
    //                 int curr = q.remove();
    //                 for(int j=0; j<graph[curr].size(); j++) {
    //                     Edge e = graph[curr].get(j);

    //                     if(color[e.dest] == -1) {
    //                         int nextColor = color[curr] == 0 ? 1 : 0;
    //                         color[e.dest] = nextColor;
    //                         q.add(e.dest);
    //                     } else if(color[curr] == color[e.dest]) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public static boolean detectCycleInUndirectedGraph(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(detectCycleInUndirectedGraphUtil(graph, i, -1, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleInUndirectedGraphUtil(ArrayList<Edge> graph[], int curr, int par, boolean isVisited[]) {
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!isVisited[e.dest]) {
                if(detectCycleInUndirectedGraphUtil(graph, e.dest, curr, isVisited)) {
                    return true;
                }
            } else if(isVisited[e.dest] && e.dest != par) {
                return true;
            }
        }

        return false;
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];

        for(int i=0; i<color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                q.add(0);
        
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        
                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
                
            }
        }
        return true;
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                bfsUtil(graph, isVisited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean isVisited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!isVisited[curr]) {
                System.out.print(curr + " ");
                isVisited[curr] = true;
            }
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                q.add(e.dest);
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

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
    }
}
