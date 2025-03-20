public class TriesClassroom {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int indx = word.charAt(level) - 'a';
            if(curr.children[indx] == null) {
                curr.children[indx] = new Node();
            }

            curr = curr.children[indx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int indx = key.charAt(i) - 'a';
            if(curr.children[indx] == null) {
                return false;
            }
            curr = curr.children[indx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }

        String key = "ilikesamsung";

        System.out.println(wordBreak(key));
    }
}
