package advanceddp;
import java.util.*;

public class KnapsackProblemPrintAllPaths15 {

    public static class Pair {
        int i;
        int j;
        String psf ;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        
        int[] wts = { 2, 5, 1, 3, 4 };
        int[] values = { 15, 14, 10, 45, 30 };
        int cap = 7; 
        int dp[][] = new int[values.length + 1][cap + 1];


        for(int i = 1; i < dp.length; i++) {

            for( int j = 1; j < dp[0].length; j++) {

                dp[i][j] = dp[i - 1][j];
                if (j >= wts[i - 1]) {
                    if (dp[i - 1][j - wts[i - 1]]+values[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + values[i - 1];
                    }
                }

            }
            
        }

        int ans = dp[values.length][cap];
        System.out.println(ans);

        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(values.length, cap, ""));

        while (que.size() > 0) {

            Pair rem = que.removeFirst();

            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {

                int exc = dp[rem.i - 1][rem.j];
                int inc = dp[rem.i - 1][rem.j - wts[rem.i - 1]] + values[rem.i - 1];

                if (dp[rem.i][rem.j] == inc) {
                    que.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], rem.psf + (rem.i - 1) + " "));
                }
                if (dp[rem.i][rem.j] == exc) {
                    que.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }

            }

        }
        

    }
    
}
