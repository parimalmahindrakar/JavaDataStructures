import java.util.*;

public class StackProb9Celebrety {

    //  
    /*
    
            0   1   2   3
        0   f   t   t   t
        1   t   f   t   f
        2   f   f   f   f
        3   t   t   t   f
    
    */


    public static void main(String[] args) {
    

    }
    

    public static void findCelebraty(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if (arr[i][j] == 1) {
                // if i knows j => i is not celeb
                st.push(j);
            } else {
                // if i don't knoww j => j is not celeb
                st.push(i);
            }
        }
        int potential = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("None");
                    return;
                }
            }
        }

        System.out.println(potential);
    }
}
