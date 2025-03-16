import java.util.*;

public class BinaryTreePractice {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrderTraverse(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void postOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);

        System.out.print(root.data + " ");
    }

    public static void inOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }

    // public static int heightOfTree(Node root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    // }

    public static int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        return countOfNodes(root.left) + countOfNodes(root.right) + 1;
    }

    public static void levelOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }

        return Math.max(heightOfTree(root.left) , heightOfTree(root.right)) + 1;
    }

    // public static int diameterOfTree(Node root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     int leftHeight = heightOfTree(root.left);
    //     int rightHeight = heightOfTree(root.right);

    //     int selfDiameter = leftHeight + rightHeight + 1;
    //     int leftDiameter = diameterOfTree(root.left);
    //     int rightDiameter = diameterOfTree(root.right);

    //     return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);
    // }

    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameterOfTree(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOfTree(root.left);
        Info rightInfo = diameterOfTree(root.right);

        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfTree(root).diameter);
    }
}
