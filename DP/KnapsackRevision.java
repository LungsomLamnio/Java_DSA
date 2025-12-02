import java.util.Arrays;

class KnapsackRevision {
    public static int knapsackRecursion(int val[], int wt[], int W, int n) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(wt[n-1] <= W) {
            int ans1 = val[n-1] + knapsackRecursion(val, wt, W-wt[n-1], n-1);
            int ans2 = knapsackRecursion(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        } else {
            return knapsackRecursion(val, wt, W, n-1);
        }
    }

    public static int knapsackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) {
            int ans1 = val[n-1] + knapsackMemoization(val, wt, W-wt[n-1], n-1, dp);
            int ans2 = knapsackMemoization(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsackMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) { //0th col
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++) { //0th row
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    int includeProfit = v + dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else {
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }

        return dp[n][W];
    }

    public static void printDp(boolean dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        //sum is zero for all the items
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = arr[i-1];
                if(v <= j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        printDp(dp);
        return dp[n][sum];
    }
    
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));
    }
}