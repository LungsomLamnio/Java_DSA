import java.util.TreeMap;

public class AmazonMedium {
    public static int minMeetingRooms(int arr[][]) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ans = 0, sum = 0;

        for(int pair[]: arr) {
            int start = pair[0];
            int end = pair[1];

            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        }

        for(int key: treeMap.keySet()) {
            sum += treeMap.get(key);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{0,30}, {5,10}, {15, 20}};
        System.out.println(minMeetingRooms(arr));
    }
}