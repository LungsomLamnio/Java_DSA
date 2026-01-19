public class AmazonMedium {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.next = next;
            this.val = val;
        }
    }

    public static void printLL(ListNode head) {
        ListNode counter = head;

        while(counter != null) {
            System.out.print(counter.val + " ");
            counter = counter.next;
        }
        System.out.println();
    }

    public static ListNode partitionList(ListNode head, int num) {
        ListNode before_head = new ListNode(-1);
        ListNode before = before_head;
        ListNode after_head = new ListNode(-1);
        ListNode after = after_head;
        ListNode counter = head;

        while(counter != null) {
            if(counter.val < num) {
                before.next = counter;
                before = before.next;
            } else {
                after.next = counter;
                after = after.next;
            }
            counter = counter.next;
        }

        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        printLL(head);
        ListNode newHead = partitionList(head, 3);
        printLL(newHead);
    }
}
