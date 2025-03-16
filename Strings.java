import java.util.Arrays;
import java.util.Scanner;

public class Strings {
    public static boolean checkPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static double shortestPath(String path) {
        int x = 0;
        int y = 0;
        for(int i=0; i<path.length(); i++) {
            if(path.charAt(i) == 'E') {
                x++;
            } else if(path.charAt(i) == 'N') {
                y++;
            } else if(path.charAt(i) == 'W') {
                x--;
            } else {
                y--;
            }
        }

        double minPath = Math.sqrt(x*x + y*y);
        return minPath;
    }

    public static String largestString(String fruits[]) {
        String str = "";

        for(int i=0; i<fruits.length; i++) {
            if(fruits[i].compareToIgnoreCase(str) > 0) {
                str = fruits[i];
            }
        }
        return str;
    }

    public static String toUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1; i<str.length(); i++) {
            sb.append(str.charAt(i));
            if(str.charAt(i) == ' ') {
                sb.append(Character.toUpperCase(str.charAt(++i)));
            }
        }
        return sb.toString();
    }

    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            int count = 1;

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }

            if(count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static boolean isAnagram(String str1, String str2) {
        if(str1.length() == str2.length()) {
            char str1CharArray[] = str1.toCharArray();
            char str2CharArray[] = str2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);

            return result;
        }
        return false;
    }
    public static void main(String[] args) {
       System.out.println(isAnagram("race", "car"));
    }
}