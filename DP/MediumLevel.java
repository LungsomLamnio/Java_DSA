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

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
