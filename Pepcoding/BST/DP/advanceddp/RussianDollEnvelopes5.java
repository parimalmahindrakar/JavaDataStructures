package advanceddp;

import java.util.*;

public class RussianDollEnvelopes5 {

    /*
     * you are given a number n, representing the number of envelopes. you are
     * givenn pair of numbers, representing the width and height Your are required
     * to print the count of max num of envelopes that can be nested inside each
     * other Note => rotation is not allowed !
     */

     public static class Envelope implements Comparable<Envelope> {

        int w, h;

        Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }
       
        public int compareTo(Envelope o) {
            return this.w - o.w;
        }

    }
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nums : ");
        int n = sc.nextInt();
        System.out.println();
        Envelope[] envs = new Envelope[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter the width : ");
            int width = sc.nextInt();
            System.out.print("Enter the height : ");
            int height = sc.nextInt();
            envs[i] = new Envelope(width, height);
            System.out.println();
        }

        Arrays.sort(envs);
        int dp[] = new int[n];
        int omax = 0;

        for (int i = 0; i < n; i++) {

            int max = 0;

            for (int j = 0; j < i; j++) {

                if (envs[j].h < envs[i].h && envs[j].w < envs[i].w) {
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

        System.out.println("Max russian dolls which can be packed : "+omax);
        sc.close();
    }

}
