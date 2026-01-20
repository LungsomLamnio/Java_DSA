public class AmazonMedium {
    public static int subArrayRanges(int nums[]) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];

            for(int j=i; j<n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);

                sum += (maxVal - minVal);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int nums[] = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums));
    }
}
