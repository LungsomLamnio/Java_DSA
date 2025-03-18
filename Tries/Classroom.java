package Tries;

public class Classroom {
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
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
    }
}
