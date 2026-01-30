public class AmazonMedium {
    public static int minSwaps(String s) {
        int countZeroes = 0;
        int countOnes = 0;
        int missingZeroes = 0;
        int missingOnes = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                countZeroes++;
            } else {
                countOnes++;
            }
        }

        if(Math.abs(countZeroes - countOnes) > 1) {
            return -1;
        }

        for(int i=0; i<s.length(); i+=2) {
            if(s.charAt(i) != '0') {
                missingZeroes++;
            } else {
                missingOnes++;
            }
        }

        return countZeroes == countOnes ? Math.min(missingZeroes, missingOnes) : countZeroes > countOnes ? missingZeroes : missingOnes;
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
    
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}