import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class AmazonMedium {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int minMeetingRooms(int arr[][]) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ans = 0, sum = 0;

        for(int pair[]: arr) {
            int start = pair[0];
            int end = pair[1];

            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        }

        for(int key: treeMap.keySet()) {
            sum += treeMap.get(key);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void inOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }

    // public static void BFS(Node root, List<Integer> ans, int k) {
    //     if(root == null) {
    //         return;
    //     }

    //     if(k == 0) {
    //         ans.add(root.data);
    //         return;
    //     }

    //     BFS(root.left, ans, k-1);
    //     BFS(root.right, ans, k-1);
    // }

    // public static void BFSUtil(Node root, Node target, int k, List<Integer> ans) {
    //     if(root == null) {
    //         return;
    //     }

    //     if(root == target) {
    //         BFS(root, ans, k);
    //     }

    //     BFSUtil(root.left, target, k, ans);
    //     BFSUtil(root.right, target, k, ans);
    // }

    // public static List<Integer> distanceK(Node root, Node target, int k) {
    //     if(root == null || target == null) {
    //         return new ArrayList<>();
    //     }

    //     List<Integer> ans = new ArrayList<>();
    //     if(root == target) {
    //         BFS(root, ans, k);
    //     } else {
    //         BFSUtil(root, target, k, ans);
    //     }

    //     return ans;
    // }

    public static void findKDown(Node root, Node targt, int k, List<Integer> ans) {
        if(root == null || k < 0) {
            return;
        }

        if(k == 0) {
            ans.add(root.data);
            return;
        }

        findKDown(root.right, targt, k-1, ans);
        findKDown(root.left, targt, k-1, ans);
    }

    public static int findDistance(Node root, Node target, int k, List<Integer> ans) {
        if(root == null) {
            return -1;
        }

        if(root == target) {
            findKDown(root, target, k, ans);
            return 0;
        }

        int dl = findDistance(root.left, target, k, ans);

        if(dl != -1) {
            if(dl+1 == k) {
                ans.add(root.data);
            } else {
                findKDown(root.right, target, k-dl-2, ans);
            }

            return dl+1;
        }

        int dr = findDistance(root.right, target, k, ans);

        if(dr != -1) {
            if(dr+1 == k) {
                ans.add(root.data);
            } else {
                findKDown(root.left, target, k-dr-2, ans);
            }

            return dr+1;
        }

        return -1;
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> ans = new ArrayList<>();
        findDistance(root, target, k, ans);
        return ans;

    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.right.right = new Node(8);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println(distanceK(root, root.left, 2));
    }
}