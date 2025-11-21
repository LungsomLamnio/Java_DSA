public class Practice {
    // Memoization
    public static int findFibonacci(int n, int f[]) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(f[n] != 0) {
            return f[n];
        }

        f[n] = findFibonacci(n-1, f) + findFibonacci(n-2, f);
        return f[n];
    }

    // Tabular
    public static int findFibonacciTab(int n, int dp[]) {
        dp[1] = 1;

        for(int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int climbingStairsRecursion(int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }
        return climbingStairsRecursion(n-1) + climbingStairsRecursion(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n+1];
        System.out.println(climbingStairsRecursion(5));
    }
}
