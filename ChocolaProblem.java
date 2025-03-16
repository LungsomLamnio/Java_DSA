import java.util.*;
public class ChocolaProblem {
    public static void main(String[] args) {
        //total number of rows and columns
        int rows = 4;
        int cols = 6;

        //cost of horizontal and vertical cut
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        //sort the arrays in desc order so that the price of cut will be minimum
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        //store the number of pieces both hor and ver, initialy it will be one
        int hp = 1;
        int vp = 1;

        //store the total cost
        int cost = 0;

        //track the index of hor and ver cost
        int h = 0;
        int v = 0;

        //cut the chocolate with the highest cost
        while(costHor.length > h && costVer.length > v) {
            if(costHor[h] >= costVer[v]) {
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else {
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
        }

        //check whether any Hor cuts remain
        while(costHor.length > h) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        //check whether any Hor cuts remain
        while(costVer.length > v) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        //display the minimum cost
        System.out.println("Minimum Cost: " + cost);
        System.out.println("Total Number of pieces: " + (vp * hp));
    }
}
