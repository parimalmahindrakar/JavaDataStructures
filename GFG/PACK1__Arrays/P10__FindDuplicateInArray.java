package PACK1__Arrays;
import java.util.*;

public class P10__FindDuplicateInArray {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 3, 4 };
        System.out.println(findDuplicate(arr));
    }
    
    public static int findDuplicate(int[] arr) {
        
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i : arr) {
            if (hs.containsKey(i)) {
                hs.put(i, hs.get(i) + 1);
            } else {
                hs.put(i, 1);
            }
        }
        
        for (int i : hs.keySet()) {
            if (hs.get(i) > 1) {
                return i;
            }
        }


        return 0;
    }
    
}
