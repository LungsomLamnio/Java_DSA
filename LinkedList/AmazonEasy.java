public class AmazonEasy {
    static class Node {
        int val;
        Node next;

        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printList(Node list) {
        Node head = list;
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    
    public static Node mergeList(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node currNode = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }

        if(l1 != null) {
            currNode.next = l1;
        } else {
            currNode.next = l2;
        }

        return dummy.next;
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverseLL(slow);
        fast = head;
        
        while(slow != null && fast != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(2, new Node(3, new Node(1))));
        printList(l1);
        System.out.println(isPalindrome(l1));
    }
}