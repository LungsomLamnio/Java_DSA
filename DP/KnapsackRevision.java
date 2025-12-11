import java.util.Arrays;
import java.util.HashSet;

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

    public static void printDp(int dp[][]) {
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

    public static int lcSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        printDp(dp);
        return ans;
    }

    public static int lcsArr(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;

        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        return lcsArr(arr, arr2);
    }
    
    public static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //add
                    int ans1 = dp[i][j-1] + 1;
                    //replace
                    int ans2 = dp[i-1][j-1] + 1;
                    //delete
                    int ans3 = dp[i-1][j] + 1;

                    dp[i][j] = Math.min(Math.min(ans1, ans2), ans3);
                }
            }
        }

        return dp[m][n];
    }

    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];
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

    public static int stringConversion(String str1, String str2) {
        int lcs = lcs(str1, str2);
        int ans = str2.length() - lcs;
        return ans + lcs;
    }

    public static boolean wildcardMatching(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();

        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int j=1; j<dp.length; j++) {
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = false;
            }
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static int catalanRec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for(int i=0; i<=n-1; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans;
    }

    public static int catalanMemo(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    public static int catalanTab(int n, int dp[]) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<=i-1; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static int countBST(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        return dp[n];
    }

    public static int mountainRanges(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<=i-1; j++) {
                int insideArrangements = dp[j];
                int outsideArrangements = dp[i-j-1];
                dp[i] += insideArrangements * outsideArrangements;
            }
        }

        return dp[n];
    }

    public static int mcm(int arr[], int i, int j) {
        if(i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;
    }

    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(mcmMemo(arr, 1, n-1, dp));
    }
}