package Sorting;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void countSort(int arr[]) {
        int maxVal = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }

        int count[] = new int[maxVal+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[j++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,4,1,3,2,4,3,7};
        printArray(arr);
        countSort(arr);
        printArray(arr);
    }
}