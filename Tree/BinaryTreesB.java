import java.util.*;
public class BinaryTreesB {
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

    static class BinaryTree {
        int indx = -1;
        public Node builTree(int nodes[]) {
            indx++;
            if(nodes[indx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = builTree(nodes);
            newNode.right = builTree(nodes);

            return newNode;
        }

        public void preOrderTraverse(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data + " ");

            preOrderTraverse(root.left);
            preOrderTraverse(root.right);

        }

        public void inOrderTraverse(Node root) {
            if(root == null) {
                return;
            }
            inOrderTraverse(root.left);
            System.out.print(root.data + " ");
            inOrderTraverse(root.right);
        }

        public void postOrderTraverse(Node root) {
            if(root == null) {
                return;
            }
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrderTraverse(Node root) {
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
                        q.add(currNode);
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

        public int heightOfTree(Node root) {
            if(root == null) {
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int countNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);

            return leftNodes + rightNodes + 1;
        }

        public int sumOfNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.left);

            return leftSum + rightSum + root.data;
        }

        public int calDiameter(Node root) {
            if(root == null) {
                return 0;
            }
            int leftDiameter = calDiameter(root.left);
            int rightDiameter = calDiameter(root.right);
            int selfDiameter = heightOfTree(root.left) + heightOfTree(root.right) + 1;

            return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
        }
    }

    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) +1 ;

        return new Info(diameter, height);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.println(diameter(root).diameter);
    }
}
