import java.util.*;

public class Classroom2 {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        //function to check empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        //function for push
        public void push(int data) {
            deque.addLast(data);
        }

        //function for remove
        public int pop() {
            return deque.removeLast();
        }

        //function for peek
        public int peek() {
            return deque.getLast();
        }
    }

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        //function to check the empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        //function to add
        public void add(int data) {
            deque.addLast(data);
        }

        //function to remove
        public int remove() {
            return deque.removeFirst();
        }

        //function to check the peek
        public int peek() {
            return deque.getFirst();
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
