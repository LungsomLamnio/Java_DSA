import java.util.*;

public class QueueF {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        //to check whether the queues are empty or not
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        //to add the data in the queues
        public void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        //to remove the elements from the queues
        public int pop() {
            if(isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }

            int top = -1;

            //case 1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { //case 2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        //to peek the elements from the queues
        public int peek() {
            if(isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }

            int top = -1;

            //case 1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { //case 2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
