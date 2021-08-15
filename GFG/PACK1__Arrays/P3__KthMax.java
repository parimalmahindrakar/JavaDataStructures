package PACK1__Arrays;

import java.util.*;

public class P3__KthMax {


    public static void main(String[] args) {
        
        int arr[] = { 4, 1, 3, 5, 7, 4, 6, -465642, 999 };
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int k = 4;
        System.out.println("Kth greatest : "+arr[arr.length-k]);


    }
    
}
