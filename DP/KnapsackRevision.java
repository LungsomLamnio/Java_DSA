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

    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++) { //if items = 0, then maxProfit = 0, 0th col=0
            dp[i][0] = 0;
        }

        for(int i=0; i<dp[0].length; i++) { //if W = 0, then maxProfit = 0, 0th row=0
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j) {
                    dp[i][j] = Math.max(v + dp[i][j-w], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        //0th col initialization
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static int rodCutting(int pieces[], int price[], int rodLength) {
        int n = price.length;
        int dp[][] = new int[n+1][rodLength+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<rodLength+1; j++) {
                if(pieces[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-pieces[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodLength];
    }

    public static int lcs(String str1, String str2, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return lcs(str1, str2, m-1, n-1) + 1;
        } else {
            int ans1 = lcs(str1, str2, m-1, n);
            int ans2 = lcs(str1, str2, m, n-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsMemo(String str1, String str2, int m, int n, int dp[][]) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return dp[m][n] = lcsMemo(str1, str2, m-1, n-1, dp) + 1;
        } else {
            int ans1 = lcsMemo(str1, str2, m-1, n, dp);
            int ans2 = lcsMemo(str1, str2, m, n-1, dp);
            return dp[m][n] = Math.max(ans1, ans2);
        }
    }

    public static int lcsTab(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(lcsTab(str1, str2));
    }
}