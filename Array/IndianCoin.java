import java.util.*;

public class IndianCoin {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        //sort the array in reverse order
        Arrays.sort(coins, Comparator.reverseOrder());

        //array to store the coins value
        ArrayList<Integer> ans = new ArrayList<>();

        //amount of coints
        int count = 0;

        //amount money
        int money = 590;

        //loop to traverse the each coin
        for(int i=0; i<coins.length; i++) {
            //check wether the amount is smaller than or equals to the coin or not
            if(coins[i] <= money) {
                //check how much same amount of coins are needed
                while(coins[i] <= money) {
                    money -= coins[i];
                    ans.add(coins[i]);
                    count++;
                }
            }

        }

        System.out.println("Total number of coins: " + count);
        System.out.print("The coins are: " + ans);
    }
}
