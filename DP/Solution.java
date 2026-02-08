class Solution {
    static int dp[] = new int[1001];
    
    public static int racecar(int target) {
        if(dp[target] > 0) {
            return dp[target];
        }

        int k = 32 - Integer.numberOfLeadingZeros(target);
        int res;

        if(target == (1 << k) - 1) {
            res = k;
        } else {
            //overshoot
            res = k + 1 + racecar((1 << k) - 1 - target);

            //undershoot
            for(int j=0; j<k-1; j++) {
                res = Math.min(res, (k-1) + 1 + j + 1 + racecar(target - ((1 << (k-1)) - (1 << j))));
            }
        }

        dp[target] = res;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(racecar(5));
    }
}