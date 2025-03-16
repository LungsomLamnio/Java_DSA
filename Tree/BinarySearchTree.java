import java.util.*;

public class BinarySearchTree {
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

    

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
        
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data > key) {
            return search(root.left, key);
        } else if(root.data < key) {
            return search(root.right, key);
        }

        return true;

    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case 1 - leaf node
            if(root.left == null  && root.right == null) {
                return null;
            } else if(root.left == null) { //case 2 - single child
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                //case 3 - both children
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data > k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int p : path) {
            System.out.print(p + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(max != null && root.data >= max.data) {
            return false;
        } else if(min != null && root.data <= min.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if(root == null) {
            return null;
        }

        Node lefNode = mirrorBST(root.left);
        Node rightNode = mirrorBST(root.right);

        root.right = lefNode;
        root.left = rightNode;

        return root;
    }

    public static boolean checkMirror(Node root, Node mirror) {
        if(root == null && mirror == null) {
            return true;
        } else if(root == null || mirror == null) {
            return false;
        }

        if(root.data != mirror.data) {
            return false;
        }

        return checkMirror(root.left, mirror.right) && checkMirror(root.right, mirror.left);
    }

    public static void preOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    // public static Node balancedBST(int arr[], int start, int end) {
    //     if(start > end) {
    //         return null;
    //     }
    //     int mid = (start + end)/2;
    //     Node root = new Node(arr[mid]);
    //     Node leftRoot = balancedBST(arr, start, mid-1);
    //     Node rightRoot = balancedBST(arr, mid+1, end);

    //     root.left = leftRoot;
    //     root.right = rightRoot;

    //     return root;
        
    // }

    // public static ArrayList<Integer> storeInroder(Node root, ArrayList<Integer> inOrder) {
    //     if(root == null) {
    //         return null;
    //     }

    //     storeInroder(root.left, inOrder);
    //     inOrder.add(root.data);
    //     storeInroder(root.right, inOrder);

    //     return inOrder;
    // }

    

    public static Node createBST(ArrayList<Integer> inOrder, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end)/2;
        Node root = new Node(inOrder.get(mid));
        root.left = createBST(inOrder, start, mid-1);
        root.right = createBST(inOrder, mid+1, end);

        return root;
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder = storeInorder(root, inOrder);

        return createBST(inOrder, 0, inOrder.size()-1);
    }

    static class Info {
        int minValue;
        int maxValue;
        boolean isBST;
        int size;
    
        public Info(int minValue, int maxValue, boolean isBST, int size) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.isBST = isBST;
            this.size = size;
        }
    }
    
    public static int maxBST = 0;
    
    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
    
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
    
        int size = leftInfo.size + rightInfo.size + 1;
        int minValue = Math.min(root.data, leftInfo.minValue);
        int maxValue = Math.max(root.data, rightInfo.maxValue);
    
        // Fixing BST validation condition
        if (root.data <= leftInfo.maxValue || root.data >= rightInfo.minValue) {
            return new Info(minValue, maxValue, false, size);
        }
    
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(minValue, maxValue, true, size);
        }
    
        return new Info(minValue, maxValue, false, size);
    }

    public static ArrayList<Integer> storeInorder(Node root, ArrayList<Integer> inOrder) {
        if(root == null) {
            return inOrder;
        }

        storeInorder(root.left, inOrder);
        inOrder.add(root.data);
        storeInorder(root.right, inOrder);

        return inOrder;
    }

    public static ArrayList<Integer> mergeArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> mergedArr = new ArrayList<>();


        int i = 0;
        int j = 0;
        while(i < arr1.size() && j < arr2.size()) {
            int val1 = arr1.get(i);
            int val2 = arr2.get(j);
            if(val1 < val2) {
                mergedArr.add(val1);
                i++;
            } else {
                mergedArr.add(val2);
                j++;
            }
        }

        while(i < arr1.size()) {
            mergedArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()) {
            mergedArr.add(arr2.get(j));
            j++;
        }

        return mergedArr;
    }

    public static Node makeBST(ArrayList<Integer> arr, int start, int end) {
        if(start > end) {
            return null;
        } 
        int mid = (start + end)/2;

        Node root = new Node(arr.get(mid));
        root.left = makeBST(arr, start, mid-1);
        root.right = makeBST(arr, mid+1, end);
        
        return root;
    }
    
    public static Node mergeBST(Node root1, Node root2) {
        ArrayList<Integer> arr1 = storeInorder(root1, new ArrayList<Integer>());
        ArrayList<Integer> arr2 = storeInorder(root2, new ArrayList<Integer>());

        ArrayList<Integer> mergedArr = mergeArray(arr1, arr2);

        return makeBST(mergedArr, 0, mergedArr.size()-1);
    }
    
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        
        Node root = mergeBST(root1, root2);
        preOrderTraverse(root);
    }
}