import java.util.*;

public class Hashing {
    public static int maxRepeatedElement(int nums[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        // Set<Integer> set = hm.keySet();
        Set<Map.Entry<Integer, Integer>> entries = hm.entrySet();
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() > nums.length/3) {
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static boolean validAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static int countDistinct(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        return set.size();
    }

    public static int findUnion(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        return set.size();
    }

    public static int findIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for (Integer i : arr2) {
            if(set.contains(i)) {
                count++;
                set.remove(i);
            }
        }

        return count;
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String ticket : tickets.keySet()) {
            revMap.put(tickets.get(ticket), ticket);
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }

    public static int largestSubArrayWithSumZero(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int length = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(hm.containsKey(sum)) {
                length = Math.max(length, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        return length;
    }

    public static int subArraySumEqualsToK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }

        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k = 3;
        System.out.println(subArraySumEqualsToK(arr, k));
    }
}
