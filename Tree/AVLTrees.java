public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(root.data > key) {
            root.left = insert(root.left, key);
        } else if(root.data < key) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = getBalance(root);

        //case - 1: LL - right rotation
        if(bf > 1 && key < root.left.data) {
            return rotateRight(root);
        }

        //case - 2: RR - rotate left
        if(bf < -1 && key > root.right.data) {
            return rotateLeft(root);
        }

        //case - 3: RL
        if(bf < -1 && key > root.left.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        //case - 4: LR
        if(bf > 1 && key < root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        return root;
    }

    public static void preOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrderTraverse(root);
    }
}