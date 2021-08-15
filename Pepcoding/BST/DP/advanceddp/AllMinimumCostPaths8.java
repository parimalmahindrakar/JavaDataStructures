package advanceddp;

import java.util.ArrayDeque;

public class AllMinimumCostPaths8 {
    

    static class Pair{

        int i, j;
        String psf;


        Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }


    }

    public static void main(String[] args) {

        int[][] arr = {

                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 }, 
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 }, 
                { 2, 7, 0, 8, 5, 1 },

        };

        int[][] dp = new int[arr.length][arr[0].length]; 

        for (int i = dp.length - 1; i >= 0; i--) {
            // i is row
            
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // j is col
                
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    
                    // if it is a last cell
                    dp[i][j] = arr[i][j];

                } else if (i == dp.length - 1) {

                    // if it is last row 
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
       
                } else if(j == dp[0].length - 1){
                    // if it is last col
                    dp[i][j] = arr[i][j] + dp[i + 1][j];

                } else {
                    // bich ka area
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);

                }

            }


        }

        // need to check again , cuz getting arrayindexoutofboundexvepection

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", 0, 0));

        while (queue.size() > 0) {
            
            Pair rem = queue.removeFirst();

            if (rem.i == dp.length - 1 && rem.j == dp[0].length - 1) {
                System.out.println(rem.psf);
                
            } else if(rem.i == dp.length - 1) {
                queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));

            } else if (rem.i == dp[0].length - 1) {
                queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                
            } else {
                
                if (dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]) {
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));

                } else if (dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]) {
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));

                } else {
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                }

            }   
        }


    }

}
