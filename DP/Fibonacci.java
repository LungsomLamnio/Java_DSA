class Fibonacci {
    public static int findFibonacci(int n, int f[]) { //memoization
        if(n == 0 || n == 1) {
            return n;
        }

        if(f[n] != 0) {
            return f[n];
        }

        f[n] = findFibonacci(n-1, f) + findFibonacci(n-2, f);
        return f[n];
    }

    public static int fib(int n) { //tabulation
        int sol[] = new int[n+1];
        sol[1] = 1;

        for(int i=2; i<=n; i++) {
            sol[i] = sol[i-1] + sol[i-2];
        }

        return sol[n];
    }
    public static void main(String[] args) { 
        int n = 5;
        int f[] = new int[n+1];
        // System.out.println(findFibonacci(n, f));
        System.out.println(fib(n));
    }
}