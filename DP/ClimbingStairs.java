public class ClimbingStairs {
    public static int climb(int n) {
        int tab[] = new int[n+1];
        tab[0] = 1;
        tab[1] = 1;
        tab[2] = 2;

        for(int i=3; i<=n; i++) {
            tab[i] = tab[i-1] + tab[i-2] + tab[i-3];
        }

        return tab[n];
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climb(n));
    }
}
