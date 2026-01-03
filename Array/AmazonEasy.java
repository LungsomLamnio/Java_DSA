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
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        System.out.println(removeDuplicatesAtmost(nums));
    }
}