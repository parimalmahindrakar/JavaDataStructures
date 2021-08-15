import java.util.*;


public class Queue2PrefixConEval {

    public static void main(String[] args) {

        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        String exp = "-+2/*6483";

        for (int i = exp.length() - 1; i >= 0; i--) {

            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1, v2, ch);
                vs.push(val);

                String inv1 = is.pop();
                String inv2 = is.pop();
                String inval = "(" + inv1 + ch + inv2 + ")";
                is.push(inval);

                String pov1 = ps.pop();
                String pov2 = ps.pop();
                String poval = pov1 + pov2 + ch;
                ps.push(poval);

            } else {
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");
            }

        }
        

        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(ps.pop());




    }
    
    public static int operation(int a, int b, char ch) {
        if (ch == '+') {
            return a + b;
        } else if (ch == '-' ) {
            return a - b;
        } else if (ch == '*' ) {
            return a * b;
        } else {
            return a / b;
        }
    }
    
}
