import java.util.Scanner;

public class Recursion {
    public static void printDec(int n) {
        if(n == 0) {
            return;
        }
        System.out.print(n + " ");

        printDec(n-1);
    }

    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    public static int printFact(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return n * printFact(n-1);
    }

    public static int sumNum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sumNum(n-1);
    }

    public static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static boolean isSortedAarray(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSortedAarray(arr, i+1);
    }

    public static int firstOcc(int arr[], int key, int indx) {
        if(indx == arr.length) {
            return -1;
        }
        if(arr[indx] == key) {
            return indx;
        }
        return firstOcc(arr, key, ++indx);
    }

    public static int lastOcc(int arr[], int key, int indx) {
        if(indx == -1) {
            return -1;
        }
        if(arr[indx] == key) {
            return indx;
        }
        return lastOcc(arr, key, --indx);
    }

    public static int power(int x, int n) {
        if(n == 0){
            return 1;
        }
        
        int halfPower = power(x, n/2);
        int halfPowerSquare = halfPower * halfPower;
        if(n%2 != 0) {
            halfPowerSquare *= x;
        }
        return halfPowerSquare;
    }

    public static int tilingProblem(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
         return tilingProblem(n-1) + tilingProblem(n-2);
    }

    public static void removeDuplicates(String str, int indx, StringBuilder newStr, boolean map[]) {
        if(indx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(indx);
        if(map[currChar - 'a'] == true) {
            removeDuplicates(str, indx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            newStr.append(currChar);
            removeDuplicates(str, indx+1, newStr, map);
        }
    }
    public static int pairProblem(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return pairProblem(n-1) + (n-1) * pairProblem(n-2);
    }

    public static void printBinaryString(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }

        printBinaryString(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinaryString(n-1, 1, str+"1");
        }
    }

    public static void findIndices(int arr[], int key, int indx) {
        if(indx == arr.length) {
            return;
        }
        if(arr[indx] == key) {
            System.out.print(indx  + " ");
        }
        findIndices(arr, key, indx+1);
    }

    public static void convertToString(int n, String digits[]) {
        if(n == 0) {
            return;
        }
        int lastDigit = n % 10;
        n /= 10;
        convertToString(n, digits);
        System.out.print(digits[lastDigit] + " ");
    }

    public static int lengthOfString(String str) {
        if(str == "") {
            return 0;
        }

        return 1 + lengthOfString(str.substring(1));
    }
    public static void main(String[] args) {
        System.out.println(lengthOfString("Nanu"));
    }
}