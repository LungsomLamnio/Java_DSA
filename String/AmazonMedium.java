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
    public static void main(String[] args) {
        String s = "111000";
        System.out.println(minSwaps(s));
    }
}