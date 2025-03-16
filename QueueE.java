import java.util.*;

public class QueueE {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //to check wether the stack is empty or not
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        //to add the element in the stack with the time complexity of O(1)
        public void add(int data) {
            s1.push(data);
        }

        //to remove the element from the stack with the time complexity of O(n)
        public int remove() {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.pop();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }

        //to peek the element from the stack with the time complexity of O(n)
        public int peek() {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.peek();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(4);
        q.add(5);
        q.add(6);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
