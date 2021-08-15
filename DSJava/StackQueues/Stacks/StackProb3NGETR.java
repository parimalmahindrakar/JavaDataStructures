import java.util.*;


public class StackProb3NGETR {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length : ");
        int len = sc.nextInt();
        int a[] = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.print("Enter the element : ");
            a[i] = sc.nextInt();
        }   

        int[] nge = solve(a);

        System.out.println("\nGreater element to right : ");
        System.out.print("[ ");
        for (int item : nge) {
            System.out.print(item + " ");
        }
        System.out.print(" ]");
        System.out.println("\n");
        sc.close();
        

    }

    public static int[] solve(int arr[]) {

        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;


        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] > st.peek())     
                st.pop();

            if (st.size() == 0) 
                nge[i] = -1;
            else 
                nge[i] = st.peek();

            st.push(arr[i]);

        }

        return nge;

    }









}
