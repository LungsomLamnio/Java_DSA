import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public void removeNode(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(Node node) {
        map.put(node.key, node);

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node currNode = map.get(key);
            removeNode(currNode);
            insertNode(currNode);
            return currNode.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node currNode = map.get(key);
            removeNode(currNode);
        }

        if(map.size() == capacity) {
            removeNode(tail.prev);
        }

        insertNode(new Node(key, val));
    }
    public static void main(String[] args) {
        LRUCache newObj = new LRUCache(2);
        newObj.put(1, 1);
        newObj.put(2, 2);
        System.out.println(newObj.get(1));
        newObj.put(3, 3);
        System.out.println(newObj.get(2));
        newObj.put(4, 4);
        System.out.println(newObj.get(1));
        System.out.println(newObj.get(3));
        System.out.println(newObj.get(4));
    }
}
