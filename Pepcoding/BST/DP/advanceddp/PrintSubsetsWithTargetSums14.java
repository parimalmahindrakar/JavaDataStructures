package advanceddp;
// need to see again.
import java.util.ArrayDeque;

public class PrintSubsetsWithTargetSums14 {

    public static class Pair {

        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }

    }

    public static void main(String[] args) {

        int[] arr = { 4, 2, 7, 1, 3 };
        int tar = 10;
        boolean dp[][] = new boolean[arr.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        // ayi hui team ne sare run bana diye
                        dp[i][j] = true;
                    } else if (j >= arr[i - 1]) {
                        if (dp[i - 1][j - arr[i - 1]] == true) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(dp[arr.length][tar]);

        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(arr.length, tar, ""));

        while (que.size() > 0) {
            Pair rem = que.removeFirst();
            boolean exc = dp[rem.i - 1][rem.j];
            if (exc) {
                que.add(new Pair(rem.i - 1, rem.j, rem.psf));
            }
            // boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]];

        }

    }
}