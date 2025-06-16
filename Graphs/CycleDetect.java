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

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
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

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                q.add(0);
                color[i] = 0;

                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if(color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[curr] == color[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
