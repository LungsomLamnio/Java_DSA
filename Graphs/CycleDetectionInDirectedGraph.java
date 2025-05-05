import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CycleDetectionInDirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                if(isCycleUtil(graph, i, isVisited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean isVisited[], boolean stack[]) {
        isVisited[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.dest]) {
                return true;
            }

            if(!isVisited[e.dest] && isCycleUtil(graph, e.dest, isVisited, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void topologicalSortDFS(ArrayList<Edge> graph[]) {
        boolean isVisited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!isVisited[i]) {
                topologicalSortUtil(graph, i, isVisited, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[], int curr, boolean isVisited[], Stack<Integer> s) { //using DFS
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]) {
                topologicalSortUtil(graph, e.dest, isVisited, s);
            }
        }

        s.push(curr);
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calInDegree(ArrayList<Edge> graph[], int inDegree[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge> graph[]) { //using BFS
        int inDegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calInDegree(graph, inDegree);

        for(int i=0; i<inDegree.length; i++) {
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
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topologicalSortBFS(graph);
    }
}
