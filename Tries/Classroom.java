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
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
    }
}
