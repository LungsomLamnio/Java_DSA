public class Divide_Conquer {
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergerSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si)/2;
        mergerSort(arr, si, mid);
        mergerSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                arr[k++] = arr[i++];
            } else {
                arr[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            arr[k++] = arr[i++];
        }
        while(j <= ei) {
            arr[k++] = arr[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pivIndx = partition(arr, si, ei);
        quickSort(arr, si, pivIndx-1);
        quickSort(arr, pivIndx+1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int sortedAndRotatedArray(int arr[], int si, int ei, int target) {
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei - si)/2;

        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] >= arr[si]) {
            if(arr[si] <= target && target <= arr[mid-1]) {
                return sortedAndRotatedArray(arr, si, mid-1, target);
            } else {
                return sortedAndRotatedArray(arr, mid+1, ei, target);
            }
        } else {
            if(arr[mid] >= target && target <= arr[ei]) {
                return sortedAndRotatedArray(arr, mid+1, ei, target);
            } else {
                return sortedAndRotatedArray(arr, si, mid-1, target);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        
    }
}