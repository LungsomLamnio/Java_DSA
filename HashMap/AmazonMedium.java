import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonMedium {
    public static List<List<String>> groupAnagrams(String words[]) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            char tempChar[] = words[i].toCharArray();
            Arrays.sort(tempChar);

            String str = String.valueOf(tempChar);

            if(map.get(str) != null) {
                List<String> mapVal = map.get(str);
                mapVal.add(words[i]);
                map.put(str, mapVal);
            } else {
                List<String> newVal = new ArrayList<>();
                newVal.add(words[i]);
                map.put(str, newVal);
            }
        }

        for(Map.Entry<String, List<String>> val: map.entrySet()) {
            ans.add(val.getValue());
        }

        return ans;
    }
    public static void main(String[] args) {
        String words[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }
}