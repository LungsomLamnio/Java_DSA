public class Recursion_1 {
    public static void printDecrease(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecrease(n-1);
    }

    public static int firstOccur(int arr[], int n, int i) {
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == n) {
            return i;
        }
        
        return firstOccur(arr, n, i+1);
    }

    public static int lastOccur(int arr[], int key, int i) {
        if(i == arr.length) {
            return -1;
        }

        int isFound = lastOccur(arr, key, i+1);

        if(isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int tilingProblem(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int vertically = tilingProblem(n-1);
        int horizontally = tilingProblem(n-2);

        int totalWays = vertically + horizontally;
        return totalWays;
    }

    public static void removeDuplicates(String str, int index, StringBuilder newStr, boolean map[]) {
        if(index == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(index);
        if(map[currChar - 'a'] == true) {
            removeDuplicates(str, index+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, index+1, newStr.append(currChar), map);
        }
    }

    public static int friPairsPro(int n) {
        if(n==1 || n==2) {
            return n;
        }
        int fnm1 = friPairsPro(n-1);
        int fnm2 = (n-1) * friPairsPro(n-2);
        int totalWays = fnm1+fnm2;
        return totalWays;
    }

    public static void printBinaryStrings(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        printBinaryStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinaryStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        printBinaryStrings(3, 0, "");
    }
}