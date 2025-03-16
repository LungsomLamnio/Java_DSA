import java.util.*;
public class MinAbsPair {
    public static void main(String[] args) {
        int a[] = {4, 1, 8, 7};
        int b[] = {2, 3, 6, 5};

        int minDiff = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }

        System.out.println("Min Diff: " + minDiff);
    }
}