import java.util.Arrays;

public class Revision {
    public static int climbingStairsUsingMemoization(int ways[], int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(ways[n] != -1) {
            return ways[n];
        }

        return climbingStairsUsingMemoization(ways, n-1) + climbingStairsUsingMemoization(ways, n-2);
    }

    public static int climbingStairsUsingTabular(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println("Tab: " + climbingStairsUsingTabular(n));
    }
}
