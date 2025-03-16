public class Revision_1 {
    public static void printDecreasing(int n) {
        //base case
        if(n == 0) {
            return;
        }
        //kaam
        System.out.print(n + " ");

        //recursion
        printDecreasing(n-1);
    }

    public static void printInc(int n) {
        //base case
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        //recursion
        printInc(n-1);

        //kaam
        System.out.print(n + " ");
    }

    public static int printFact(int n) {
        //base case
        if(n == 1) {
            return 1;
        }
        //recursion
        int fnm1 = printFact(n-1);

        //kaam
        int fact = n * fnm1;
        return fact;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(printFact(n));
    }
}