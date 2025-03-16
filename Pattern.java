public class Pattern {
    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(i + " ");
                if(j == 1) {
                    System.out.print((i+4) + " ");
                }
                if(j == 2) {
                    System.out.print((i+7) + " ");
                }
                if(j == 3) {
                    System.out.print((i+9) + " ");
                }
                if(j == 4) {
                    System.out.print((i+10) + " ");
                }
            }
        }
    }
}
