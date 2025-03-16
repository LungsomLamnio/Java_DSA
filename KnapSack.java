import java.util.*;
public class KnapSack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        //ratio value/weight
        double ratio[][] = new double[val.length][2];
        //0th col -> index and 1st col -> ratio

        //asigning values
        for(int i=0; i<ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //sorting in ascending order using lambda function
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        //finding the final value
        int finalVal = 0;
        int capacity = w;

        //as we need the maximum ratio we will find in descending order of the ratio array
        for(int i=ratio.length-1; i>=0; i--) {
            int indx = (int)ratio[i][0];
            // we need to check whether the weight of the items will able to adjust the sack or not
            if(capacity >= weight[indx]) {
                //if capacity available add the value to the final
                finalVal += val[indx];
                //now decrease that amount of weight from the capacity
                capacity -= weight[indx];
            } else { //if the weight is more than the capacity, then just add the required amount of weight
                finalVal += (ratio[i][1] * capacity);
            }
        }

        System.out.println("Final Value: " + finalVal);
    }
}