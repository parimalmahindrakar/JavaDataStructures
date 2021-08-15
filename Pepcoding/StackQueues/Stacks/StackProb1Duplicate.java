import java.util.*;

public class StackProb1Duplicate {

    public static void main(String[] args) {

        /*
         * you are given a string exp representing an expression. Assume that the expr
         * is balanced i.e. the opening and closing brackets match with each other. But
         * some of the pair of brackets maybe extra/needless. You are required to print
         * true if you detect extra brackets and false otherwise. Ex. ((a+b)+(c+d)) =>
         * not duplicacy (a+b)+((c+d)) => duplicacy
         * 
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String str = sc.nextLine();
        sc.close();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    System.out.println("Duplicacy is there !");
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }

        }

        System.out.println("Duplicacy is not there !");

    }

}
