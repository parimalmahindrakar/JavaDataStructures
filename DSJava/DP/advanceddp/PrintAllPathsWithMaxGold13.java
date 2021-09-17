package advanceddp;

import java.util.ArrayDeque;

public class PrintAllPathsWithMaxGold13 {

   
    private static class Pair {

        String psf;
        int i;
        int j;

        Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }

    }

    public static void main(String[] args) {

        int arr[][] = {

                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 }, 
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 }, 
                { 2, 7, 0, 8, 5, 1 } 
        };

        int[][] dp = new int[arr.length][arr[0].length];

        for (int j = arr[0].length - 1; j >= 0; j--) {

            for (int i = 0; i < arr.length; i++) {

                if (j == arr[0].length - 1)
                    dp[i][j] = arr[i][j];

                else if (i == 0)
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);

                else if (i == arr.length - 1)
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                
                else
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));

            }

        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println("Max : "+max);

        ArrayDeque<Pair> que = new ArrayDeque<>();

        for(int i = 0; i < dp.length; i++) {
            if(dp[i][0] ==  max) {
                que.add(new Pair(i + "", i, 0));
            }
        }

        while (que.size() > 0) {
            
            Pair rem = que.removeFirst();
            if (rem.j == arr[0].length - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == 0) {
                
                int greater = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);
                
                if (greater == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1));
                }
                if (greater == dp[rem.i + 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d3", rem.i + 1, rem.j + 1));
                }
                
            } else if (rem.i == arr.length - 1) {

                int greater = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);

                if (greater == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1));
                }
                if (greater == dp[rem.i - 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d1", rem.i - 1, rem.j + 1));
                }
                
            } else {

                int greater = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1],dp[rem.i + 1][rem.j + 1]));

                if (greater == dp[rem.i + 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d1", rem.i, rem.j + 1));
                }
                if (greater == dp[rem.i][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1));
                }
                if (greater == dp[rem.i + 1][rem.j + 1]) {
                    que.add(new Pair(rem.psf + " d3", rem.i + 1, rem.j + 1));
                }

            }

        }
 
    }

}
