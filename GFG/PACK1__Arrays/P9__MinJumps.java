package PACK1__Arrays;

public class P9__MinJumps {

    /*
    
    Given an array of N integers arr[] where each element represents  
    the max number of steps that can be made forward from that element. 
    Find the minimum number of jumps to reach the end of the array 
    (starting from the first element). If an element is 0, then you 
    cannot move through that element.Note: Return -1 if you can't reach 
    the end of the array.
    
    */

    public static void main(String args[])
    {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "
                         + minJumps(arr, 0, n - 1)+"\n");
    }

    static int minJumps(int arr[], int l, int h){
    
        if (h == l)
            return 0;
 
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }
        int min = Integer.MAX_VALUE;
        
        for (int i = l + 1; i <= h && i <= (l + arr[l]); i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }
    
}
