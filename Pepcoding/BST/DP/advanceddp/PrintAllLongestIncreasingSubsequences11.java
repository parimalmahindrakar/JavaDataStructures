package advanceddp;

import java.util.ArrayDeque;

public class PrintAllLongestIncreasingSubsequences11 {

    public static class Pair {

        int l;
        int i;
        int val;
        String psf;

        Pair(int l, int i, int v, String psf)  {
            
            this.l = l;
            this.i = i;
            this.val = v;
            this.psf =psf;
        }

    }

    public static void PrintSolution(int[] arr) {

        int n = arr.length;

        int omax = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        int omi = 0;

        for (int i = 0; i < dp.length; i++) {

            int max = 0;

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {

                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
                omi = i;
            }

        }
        System.out.println("\nLongest subsequences : "+omax);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(omax, omi, arr[omi], arr[omi] + ""));

        while(queue.size() > 0 ) {

            Pair rem = queue.removeFirst();
            
            if (rem.l == 1) {
                System.out.print("Path : ");
                System.out.println(rem.psf);
                
            }

            for(int j = 0; j< rem.i; j++) 
                if (dp[j] == rem.l - 1 && arr[j] <= rem.val)
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " => " + rem.psf));

        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
        PrintSolution(arr);

    }
}
