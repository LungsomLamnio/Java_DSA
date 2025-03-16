import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    public static void printReverse(ArrayList<Integer> list) {
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static int findMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void sortAsc(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    public static void sortDes(ArrayList<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    public static void swap(ArrayList<Integer> list, int indx1, int indx2) {
        int num1 = list.get(indx1);
        int num2 = list.get(indx2);

        list.set(indx1, num2);
        list.set(indx2, num1);
    }

    public static void traverseMultiArray(ArrayList<ArrayList<Integer>> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void multiArrayList() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        mainList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        mainList.add(list2);

        traverseMultiArray(mainList);
    }

    public static int mostWater(ArrayList<Integer> height) {
        int maxWater = 0;
        

        for(int i=0; i<height.size()-1; i++) {
            int h1 = height.get(i);
            for(int j=i+1; j<height.size(); j++) {
                int h2 = height.get(j);
                int minHeight = Math.min(h1, h2);
                int currWater = (j - i) * minHeight;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int i = 0;
        int j = height.size()-1;

        while(i < j) {
            int h1 = height.get(i);
            int h2 = height.get(j);

            int minHeight = Math.min(h1, h2);
            int currWater = (j-i) * minHeight;
            maxWater = Math.max(maxWater, currWater);

            if(h1 < h2) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int i = 0;
        int j = list.size()-1;

        while(i < j) {
            if(list.get(i) + list.get(j) == target) {
                return true;
            } else if(list.get(i) + list.get(j) < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer>list, int target) {
        int bp = -1;
        int n = list.size();
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;

        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            } else if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1)%n;
            } else {
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);

        System.out.println(pairSum2(height, 16));
    }
}