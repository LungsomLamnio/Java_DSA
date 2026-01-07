public class MediumLevel {
    public static int lastStoneWeightII(int stones[]) {
        int n = stones.length;
        int totalSum = 0;

        for(int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum/2;
        int dp[][] = new int[n+1][target+1];

        for(int i=1; i<n+1; i++) {
            int currStone = stones[i-1];
            for(int j=1; j<target+1; j++) {
                if(currStone <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], currStone + dp[i-1][j-currStone]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int maxSumSubset = dp[n][target];
        printDP(dp);
        return totalSum - 2 * maxSumSubset;
    }

    public static void printDP(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int stones[] = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
}
