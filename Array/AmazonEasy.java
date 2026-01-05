public class AmazonEasy {
    // Remove Duplicates from Sorted Array
    public static int removeDuplicates(int nums[]) {
        int i = 0;
        for(int j=1; j<nums.length; j++) {
            if(nums[i] < nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
        }

        return i+1;
    }

    // Remove Duplicates from Sorted Array with at most twice appearance of unique elements
    public static int removeDuplicatesAtmost(int nums[]) {
        int k = 2;
        for(int i=2; i<nums.length; i++) {
            if(nums[i] != nums[k-2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void mergeSortedArray(int nums1[], int nums2[], int m, int n) {
        int i = m-1;
        int j = n-1;
        int p = m+n-1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[p] = nums1[i];
                i--; p--;
            } else {
                nums1[p] = nums2[j];
                j--; p--;
            }
        }

        while(i >= 0) {
            nums1[p] = nums1[i];
            i--; p--;
        }

        while(j >= 0) {
            nums1[p] = nums2[j];
            j--; p--;
        }
    }

    public static int[][] pascalsTriangle(int n) {
        int ans[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0 || i == j) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
                }
            }
        }
        return ans;
    }

    public static void print2DArray(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int missingNumber(int nums[]) {
        int n = nums.length;
        for(int i=0; i<nums.length; i++) {
            n = n ^ i;
            n = n ^ nums[i];
        }

        return n;
    }

    public static void main(String[] args) {
        int nums[] = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}