import java.util.*;

public class StackProb7InfixEvaluation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Stack<Integer> opends = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
    
            char ch = str.charAt(i);
            if (ch == '(') {
                optors.push(ch);
            } else if (Character.isDigit(ch)) {
                opends.push(ch - '0'); // 0's ascii value is 48 i.e. ch - 48
                // subtracting the ascii value to get the perfect int value
            } else if (ch == ')') {
                while (optors.peek() != '(') {
                    char optor = optors.pop();
                    int v2 = opends.pop();
                    int v1 = opends.pop();
                    int opv = operation(v1, v2, optor);
                    opends.push(opv);
                }
                optors.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //ch wanting the higher priority operators to solve first
                while (optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) {
                    char optor = optors.pop();
                    int v2 = opends.pop();
                    int v1 = opends.pop();
                    int opv = operation(v1, v2, optor);
                    opends.push(opv);
                }
                // ch is putting itself now
                optors.push(ch);
            }
        }
        while (optors.size() > 0) {
            char optor = optors.pop();
            int v2 = opends.pop();
            int v1 = opends.pop();
            int opv = operation(v1, v2, optor);
            opends.push(opv);
        }
        System.out.println(opends.peek());
    }
    


    public static int precedence(char optor) {
        if (optor == '+') {
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char optor) {
        if (optor == '+') {
            return v1 + v2;
        } else if (optor == '-') {
            return v1 - v2;
        } else if (optor == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
