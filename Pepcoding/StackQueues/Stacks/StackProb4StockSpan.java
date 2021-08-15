import java.util.*;

public class StackProb4StockSpan {

    public static void main(String[] args) {

        int a[] = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        System.out.println();
        for (int item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
        int span[] = solve(a);
        System.out.println();
        for (int item : span) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    public static int[] solve(int[] arr) {

        int span[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {

            while (st.size() > 0 && arr[i] > arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                span[i] = i + 1;
            else
                span[i] = i - st.peek();

            st.push(i);

        }
        
        return span;

    }

}

