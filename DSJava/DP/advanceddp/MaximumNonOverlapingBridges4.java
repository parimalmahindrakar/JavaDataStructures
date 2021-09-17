package advanceddp;

import java.util.*;

public class MaximumNonOverlapingBridges4 {

    public static class Bridge implements Comparable<Bridge> {

        int n, s;

        Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o) {
            if (this.n != o.n) {
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int n = sc.nextInt();
        
        System.out.println();
        Bridge[] bdgs = new Bridge[n];
        for (int i = 0; i < n; i++) {

            System.out.print("Enter the north : ");            
            int north = sc.nextInt();
            System.out.print("Enter the south : ");
            int south = sc.nextInt();
            bdgs[i] = new Bridge(north, south);
            System.out.println();
        }

        Arrays.sort(bdgs);
        int[] dp = new int[n];
        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {

                if (bdgs[j].s < bdgs[i].s) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }

        }

        System.out.println("Maximum non-overlaping bridges : " + omax);
        System.out.println();
        sc.close();
    }

}


/*
        Input : 8 1 4 3 5 2 6 7 
                1 2 3 4 5 6 7 8
        Output : Maximum number of bridges = 5
*/