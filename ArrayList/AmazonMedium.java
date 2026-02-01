import java.util.ArrayList;
import java.util.List;
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

    public static List<Integer> goodDaysToRobBank(int security[], int time) {
        int len = security.length;
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        int prefix[] = new int[len];
        int suffix[] = new int[len];

        for(int i=1; i<len; i++) {
            if(security[i] <= security[i-1]) { //decreasing
                count++;
            } else {
                count = 0;
            }
            prefix[i] = count;
        }

        count = 0;

        for(int i=len-2; i >= 0; i--) {
            if(security[i] <= security[i+1]) {
                count++;
            } else {
                count = 0;
            }
            suffix[i] = count;
        }

        for(int i=0; i<len; i++) {
            if(prefix[i] >= time && suffix[i] >= time) {
                ans.add(i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int time = 3;
        int security[] = {0,0,0,0,0};
        System.out.println(goodDaysToRobBank(security, time));
    }
}