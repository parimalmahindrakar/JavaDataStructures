package PACK1__Arrays;
import java.util.*;

public class P19__SubarrayMinScore {

    public static void main(String[] args) {

        int arr[] = { 3, 106, 109, 125, 9, 53, 102, 106, 96 };
        System.out.println(findMinInSubarray(arr));

    }
    
    public static int findMinInSubarray(int[] arr) {

        int min = Integer.MAX_VALUE;

        ArrayList<Integer> al = new ArrayList<>();
        for (int i : arr) {
            if (i >= 100) {
                al.add(i);
            } else {
                al.add(0);
            }
        }

        ArrayList<ArrayList<Integer>> al2 = new ArrayList<>();
        ArrayList<Integer> al3 ;

        for (int i = 0; i < al.size(); i++) {
            al3 = new ArrayList<>();
            if (al.get(i) != 0) {
                int j = i;
                while (al.get(j) != 0) {
                    al3.add(al.get(j));
                    j++;
                }
                i = j;
            }
            al2.add(al3);
        }

        int cnt = 0;
        int id = -1;
        for (ArrayList<Integer> al4 : al2) {
            if (al4.size() > cnt) {
                cnt = al4.size();
                id = al2.indexOf(al4);
            }
        }
        for (int k : al2.get(id)) {
            if (k < min) {
                min = k;
            }
        }
        return min;
    }
    
}
