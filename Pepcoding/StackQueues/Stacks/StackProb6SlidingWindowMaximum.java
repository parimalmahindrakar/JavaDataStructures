import java.util.*;

public class StackProb6SlidingWindowMaximum {

    public static void main(String[] args) {

        int arr[] = { 2, 9, 3, 8, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6 };
        System.out.println(arr.length); // 16
        for (int item : arr) {
            System.out.print(item + "\t");
        }
        System.out.println();

        int k = 4;// to jump on size of 4
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] >= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                nge[i] = arr.length;
            else
                nge[i] = st.peek();

            st.push(i);
        }

        for (int item : nge) {
            System.out.print(item + "\t");
        }
        System.out.println();

        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 => indices

        // 2 9 3 8 7 12 6 14 4 32 0 7 19 8 12 6 => arr
        // 1 5 3 5 5 7 7 9 9 16 11 12 16 14 16 16 => nge

        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {

            // enter the loop to find the maximum of window starting at i.
            if (i > j)
                j = i;

            while (nge[j] < i + k)
                j = nge[j];

            System.out.print(arr[j] + "\t");
        }
        System.out.println();

    }

}
