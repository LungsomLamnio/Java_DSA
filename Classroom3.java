import java.util.*;
public class Classroom3 {
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

    // static class Info {
    //     int diameter;
    //     int height;

    //     Info(int diameter, int height) {
    //         this.diameter = diameter;
    //         this.height = height;
    //     }
    // }

    // public static Info diameter(Node root) {
    //     if(root == null) {
    //         return new Info(0, 0);
    //     }
    //     Info leftInfo = diameter(root.left);
    //     Info rightInfo = diameter(root.right);

    //     int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
    //     int height = Math.max(leftInfo.height, rightInfo.height) + 1;

    //     return new Info(diameter, height);
    // }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void levelOrder(Node root) {
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

    static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        //first we need to do level order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()) {
            Info currInfo = q.remove();
            if(currInfo == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(currInfo.hd)) {
                    map.put(currInfo.hd, currInfo.node);
                }
    
                if(currInfo.node.left != null) {
                    q.add(new Info(currInfo.node.left, currInfo.hd-1));
                    min = Math.min(min, currInfo.hd-1);
                }
    
                if(currInfo.node.right != null) {
                    q.add(new Info(currInfo.node.right, currInfo.hd+1));
                    max = Math.max(max, currInfo.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void printKthLevel(Node root, int k, int level) {
        if(root == null) {
            System.out.println("Kth level does not exist.");
            return;
        }

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        printKthLevel(root.left, k, level+1);
        printKthLevel(root.right, k, level+1);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }
        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lowestCommonAncestor2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lowestCommonAncestor2(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor2(root.right, n1, n2);

        if(leftLca == null) {
            return rightLca;
        }

        if(rightLca == null) {
            return leftLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftVal = lcaDist(root.left, n);
        int rightVal = lcaDist(root.right, n);

        if(leftVal != -1) {
            return leftVal + 1;
        } else if(rightVal != -1) {
            return rightVal + 1;
        } else {
            return -1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lowestCommonAncestor2(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthNode(Node root, int k, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = kthNode(root.left, k, n);
        int rightDist = kthNode(root.right, k, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    } 

    public static int sumOfSubTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfSubTree(root.left);
        int rightSum = sumOfSubTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.left == null ? 0 : root.right.data;

        root.data = leftSum + newLeft + rightSum + newRight;

        return data;
    }

    // public static boolean checkUniValued(Node root, int rootData) {
    //     if(root == null) {
    //         return true;
    //     }

    //     if(root.data != rootData) {
    //         return false;
    //     }

    //     boolean leftCheck = checkUniValued(root.left, rootData);
    //     boolean rightCheck = checkUniValued(root.right, rootData);


    //     if(leftCheck == false || rightCheck ==  false) {
    //         return false;
    //     } else { 
    //         return true;
    //     }
    // }

    public static boolean isUnivalued(Node root, int rootData) {
        if(root == null) {
            return true; //we have crossed the leaf nodes which means all the previous values are univalued
        }

        if(root.data != rootData) {
            return false;
        }

        return isUnivalued(root.left, rootData) && isUnivalued(root.right, rootData);
    }

    public static boolean checkUniValued(Node root) {
        if(root == null) {
            return true; //empty tree is also a univalued binary tree
        }

        return isUnivalued(root, root.data);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(2);

        System.out.println(checkUniValued(root));        
    }
}
