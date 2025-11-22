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

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(climbingStairsUsingMemoization(ways, n));
    }
}
