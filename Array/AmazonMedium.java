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

    public static boolean carPooling(int trips[][], int capacity) {
        int val[] = new int[1001];
        for(int trip[] : trips) {
            val[trip[1]] += trip[0];
            val[trip[2]] -= trip[0];
        }

        for(int i=0; capacity>=0 && i<1001; i++) {
            capacity -= val[i];
        }

        return capacity >= 0;
    }
    public static void main(String[] args) {
        int trips[][] = {{2,1,5},{3,3,7}};
        int capacity = 5;
        System.out.println(carPooling(trips, capacity));
    }
}
