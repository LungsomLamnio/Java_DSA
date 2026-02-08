class Solution {
    static int dp[] = new int[10001];

    public static int racecar(int target) {
        if(dp[target] > 0) return dp[target];

        int k = 32 - Integer.numberOfLeadingZeros(target);
        int res;

        if(target == (1 << k) -1) {
            res = k;
        } else {
            res = k + 1 + racecar((1 << k) - 1 - target);

            for(int j = 0; j < k-1; j++) {
                res = Math.min(res, (k-1) + 2 + j + racecar(target - ((1 << (k-1)) - (1 << j))));
            }
        }

        dp[target] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(racecar(6));
    }
}