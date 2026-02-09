import java.util.Stack;

public class AmazonHard {
    public static int longestValidParenthesis(String str) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int ans = 0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ')') {
                int curr = s.pop();
                if(s.isEmpty()) {
                    s.push(i);
                } else {
                    ans = Math.max(ans, i - s.peek());
                }
            } else {
                s.push(i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longestValidParenthesis(str));
    }
}
