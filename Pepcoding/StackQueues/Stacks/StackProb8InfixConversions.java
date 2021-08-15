import java.util.*;

public class StackProb8InfixConversions {

    // a* ( b - c ) / d + e => Infix
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        sc.close();

        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch + "");
            } else if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != "(") {
                    String op = ops.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = prev1 + prev2 + op;
                    pre.push(prev);
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (ops.peek() != "(" && ops.size() > 0 && precedence(ch) <= precedence('a') ) { // error here.

                    String op = ops.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = prev1 + prev2 + op;
                    pre.push(prev);
                }
            }

        }

    }

    public static int precedence(char op) {

        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }

    }
}
