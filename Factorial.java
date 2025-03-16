import java.util.Scanner;

public class Factorial {
    public static int findFactorial(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return n * findFactorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Factorial of " + n + " is: " + findFactorial(n));
    }
}
