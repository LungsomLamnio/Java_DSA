class Fibonacci {
    public static int findFibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return findFibonacci(n-1) + findFibonacci(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFibonacci(n));
    }
}