import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
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
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
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

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycleUndirected(graph));
    }
}
