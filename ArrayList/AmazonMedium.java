import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AmazonMedium {
    public static boolean courseSchedule(int numCourses, int prerequisites[][]) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int inDegree[] = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int pre[]: prerequisites) {
            adj[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for(int j: adj[curr]) {
                if(--inDegree[j] == 0) {
                    queue.add(j);
                }
            }
        }

        return count == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int prerequisites[][] = {{1,0}};
        System.out.println(courseSchedule(numCourses, prerequisites));
    }
}