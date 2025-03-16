package Heap;
import java.util.*;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size()-1; //child index
            int parIndx = (x-1)/2;

            while(arr.get(x) < arr.get(parIndx)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parIndx));
                arr.set(parIndx, temp);

                x = parIndx;
                parIndx = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIndx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minIndx)) {
                minIndx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIndx)) {
                minIndx = right;
            }

            if(minIndx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndx));
                arr.set(minIndx, temp);

                heapify(minIndx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            int temp = data;
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);

            heapify(0);
            return data;

        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIndx = i;

        if(left < size && arr[left] > arr[maxIndx]) {
            maxIndx = left;
        }

        if(right < size && arr[right] > arr[maxIndx]) {
            maxIndx = right;
        }

        if(maxIndx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIndx];
            arr[maxIndx] = temp;

            heapify(arr, maxIndx, size);
        }
    }

    public static void heapSort(int arr[]) {
        //step - 1: build max heap
        int n = arr.length-1;
        for(int i=n/2; i>=0; i--) {
            heapify(arr, i, n);
        }

        //step - 2: push largest at the end
        for(int i=n; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heapSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
