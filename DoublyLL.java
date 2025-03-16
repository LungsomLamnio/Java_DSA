public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void traverse() {
        if(head == null) {
            System.out.println("Empty DLL");
            return;
        }
        Node ptr = head;
        while(ptr != null) {
            System.out.print(ptr.data + "<->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {
        if(head == null) {
            System.out.println("Empty DoublyLL");
            return -1;
        } else if(size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.traverse();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.traverse();
        dll.reverse();
        dll.traverse();
    }
}