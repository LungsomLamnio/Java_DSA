import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonMedium {
    public static List<Integer> kClosestElements(int arr[], int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: arr) {
            if(k>0) {
                minHeap.add(num);
                k--;
            } else if(Math.abs(minHeap.peek() - x) > Math.abs(num - x)) {
                minHeap.remove();
                minHeap.add(num);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            list.add(minHeap.remove());
        }

        return list;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(kClosestElements(arr, 4, 3));
    }
}
