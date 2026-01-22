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

    public static int kthLargestElement(int nums[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.add(num);
        }

        while(minHeap.size() != k) {
            minHeap.remove();
        }

        return minHeap.peek();
    }
    public static void main(String[] args) {
        int arr[] = {3,2,1,5,6,4};
        System.out.println(kthLargestElement(arr, 2));
    }
}
