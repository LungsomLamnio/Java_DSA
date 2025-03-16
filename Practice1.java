public class Practice1 {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL"; //output -> LR, RRLL, RLLR (3)

        //counter variable
        int counter = 0;

        //count balance substring
        int balance = 0;

        //track the starting index
        int start = 0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'L') {
                counter++;
            } else {
                counter--;
            }

            if(counter == 0) {
                balance++;
                System.out.println(str.substring(start, i+1));
                start = i+1;
            }
        }

        System.out.println("Balance Substring: " + balance);
    }
}
