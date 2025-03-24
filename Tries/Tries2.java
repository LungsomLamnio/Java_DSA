public class Tries2 {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int indx = word.charAt(i) - 'a';
            if(curr.children[indx] == null) {
                curr.children[indx] = new Node();
            }

            curr = curr.children[indx];
        }

        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int indx = word.charAt(i) - 'a';

            if(curr.children[indx] == null) {
                return false;
            }

            curr = curr.children[indx];
        }

        return curr.eow == true;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int indx = prefix.charAt(i) - 'a';

            if(curr.children[indx] == null) {
                return false;
            }

            curr = curr.children[indx];
        }

        return true;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            count += countNodes(root.children[i]);
        }

        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a');
                temp.append(ch);

                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
