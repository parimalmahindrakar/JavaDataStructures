import java.util.*;


public class DS2LongestConsSequence {

    public static void main(String[] args) {
        
        int[] arr = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };
        HashMap<Integer,Boolean> hs = new HashMap<>();
        for (int i : arr) {
            hs.put(i, true);
        }

        for (int i : arr) {
            if (hs.containsKey(i - 1)) {
                hs.put(i, false);
            }
        }

        int msp = 0;
        int m1 = 0;

        for (int val : arr) {
            if (hs.get(val) == true) {
                int t1 = 1;
                int tsp = val;
                while (hs.containsKey(tsp + t1)) {
                    t1++;
                }
                if (t1 > m1) {
                    msp = tsp;
                    m1 = t1;
                }
            }
        }

        System.out.print("[ ");
        for (int i = 0; i < m1; i++) {
            System.out.print((msp + i) + " ");
        }
        System.out.print(" ]\n");
        


    }

}









