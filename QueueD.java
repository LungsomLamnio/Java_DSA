import java.util.*;

public class QueueD {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //to check wether the stack is empty or not
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        //to add the elements in the stack
        public void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //to remove the elements from the stack
        public int remove() {
            if(s1.isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }

            return s1.pop();
        }

        //to peek the top element in the stack
        public int peek() {
            if(s1.isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }

            return s1.peek();
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
