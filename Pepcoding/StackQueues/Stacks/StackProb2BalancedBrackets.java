import java.util.*;

public class StackProb2BalancedBrackets {

      public static void main(String[] args) {

            String expr1 = "(a+b)+(c+d)";
            String expr2 = "(a+b)+(c+d))";

            boolean isBalanced1 = isBalanced(expr1);
            boolean isBalanced2 = isBalanced(expr2);

            System.out.println("Expr 1 is balanced : " + isBalanced1);
            System.out.println("Expr 2 is balanced : " + isBalanced2);

       }


        public static boolean isBalanced(String expr) {


            Stack<Character> st = new Stack<>();
            boolean b1 = true;
            boolean b2 = true;
            boolean b3 = true;

            for (int i = 0; i < expr.length(); i++) {

                char ch = expr.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    st.push(ch);
                } else if (ch == ')') {
                    b1 = HandleClosing(st, '(');
                } else if (ch == ']') {
                    b2 = HandleClosing(st, '[');
                } else if (ch == '}') {
                    b3 = HandleClosing(st, '{');
                } else {

                }

            }
            
            if (st.size() == 0 && b1 && b2 && b3)  {
                return true;
            } else {
                return false;
            }

        }


        public static boolean HandleClosing(Stack<Character> st, char ch) {

            if (st.size() == 0) {
                return false;
            } else if (st.peek() != ch) {
                return false;
            } else {
                st.pop();
                return true;
            }

        }

}
