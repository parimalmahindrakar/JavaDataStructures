package PACK1__Arrays;
import java.util.*;

public class P21__ChocklateDistricution {

    static int findMinDiff(int arr[], int n,int m){
                                    
        if (m == 0 || n == 0)
            return 0;
      
        Arrays.sort(arr);

        // num of students can't be more that num of packats
        if (n < m)
           return -1;
      
        int min_diff = Integer.MAX_VALUE;
 
        for (int i = 0; i + m - 1 < n; i++){
            int diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }
    
}
