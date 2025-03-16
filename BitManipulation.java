import java.util.Scanner;;

public class BitManipulation {
    public static int setIthBit(int n, int pos) {
        int bitMask = 1 << pos;
        return n | bitMask;
    }
    public static int getIthBit(int n, int pos) {
        int bitMask = 1 << pos;
        if((n & bitMask) == 0) {
            return 0;
        }
        return 1;
    }
    public static String oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            return "even";
        }
        return "odd";
    }
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static void printNumber(int n) {
        if(n == 0) {
            return;
        }
        System.out.print(n + " ");

        printNumber(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        printNumber(n);
    }
}