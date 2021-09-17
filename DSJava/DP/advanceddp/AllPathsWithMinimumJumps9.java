package advanceddp;
import java.util.*;

public class AllPathsWithMinimumJumps9 {

    /*
    * You are given a number N represeinting number of elements. You are given N
    * space seperated numbers(ELE:elements) Your task is to find & print
    * "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    * All configurations of "MINIMUM JUMPS" 
    */

    public static class Pair {

        int i, size, jumps;
        String psf;

        Pair(int i, int size, int jumps, String psf) {
            this.i = i;
            this.size = size;
            this.jumps = jumps;
            this.psf = psf;
        }


    }

    public static void Solution(int arr[]) {
        
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {

            int steps = arr[i];
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= steps && i + j < arr.length; j++) {

                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }

            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }

        }
        
        System.out.println("Maximum jumps : " + dp[0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, arr[0], dp[0], 0 + ""));

        while (queue.size() > 0) {
            
            Pair rem = queue.removeFirst();

            if (rem.jumps == 0) {
                System.out.println(rem.psf);
            }

            for (int j = 1; j <= rem.size && rem.i + j < arr.length; j++) {
                
                int ci = rem.i + j;
                
                if (dp[ci] != null && dp[ci] == rem.jumps -  1) {
                    queue.add(new Pair(ci, arr[ci], dp[ci], rem.psf + " -> " + ci));
                }

            }

        }
    }






    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution(arr);
        sc.close();

    }



}
