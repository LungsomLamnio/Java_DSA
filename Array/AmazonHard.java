import java.util.Arrays;

public class AmazonHard {
    public static int countPairs(int nums[], int mid) {
        int count = 0;
        int left = 0;

        for(int right=0; right<nums.length; right++) {
            while(nums[right] - nums[left] > mid) {
                left++;
            }

            count += right - left;
        }

        return count;
    }
    public static int smallestDistancePair(int nums[], int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0;
        int high = nums[n-1] - nums[0];

        while(low < high) {
            int mid = low + (high - low)/2;
            if(countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static double findMedianSortedArrays(int nums1[], int nums2[]) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while(low <= high) {
            int m1 = (low + high)/2;
            int m2 = (m + n + 1)/2 - m1;

            int L1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1-1];
            int R1 = (m1 == m) ? Integer.MAX_VALUE : nums1[m1];

            int L2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2-1];
            int R2 = (m2 == n) ? Integer.MAX_VALUE : nums2[m2];

            if(L1 <= R2 && L2 <= R1) {
                if((m+n)%2 != 0) {
                    return (double) Math.max(L1, L2);
                } else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if(L1 > R2) {
                high = m1 - 1;
            } else {
                low = m1 + 1;
            }
        }

        return 0.0;
    }
    public static void main(String[] args) {
        int nums1[] = {1,3};
        int nums2[] = {2,5,7};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
