package PACK1__Arrays;

public class P20__TrapRainwater {

    public static void main(String[] args) {
        
        int arr[] = {6,9,9 };
        

        int n = arr.length;
        int res = 0;
        for(int i = 1; i < n - 1; i++)
        {
             
            // Find maximum element on its left
            int left = arr[i];
            for(int j = 0; j < i; j++)
            {
                left = Math.max(left, arr[j]);
            }
     
            // Find maximum element on its right
            int right = arr[i];
            for(int j = i + 1; j < n; j++)
            {
                right = Math.max(right, arr[j]);
            }
     
            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
       System.out.println(res);
    }
    
}
