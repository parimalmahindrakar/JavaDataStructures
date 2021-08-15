package advanceddp;
public class MaximumSumIncreasingSubsequences2 {

    /*
     * You are given a number n, representing the number of elements. You are given
     * n numbers, representing the contents of array of length n. You are required
     * to print the sum of elements of the increasing subsequences with maximum sum
     * for the array.
     */

    public static void main(String[] args) {

        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
        int n = arr.length;

        int omax = Integer.MIN_VALUE;
        int dp[] = new int[n];

        for (int i = 0; i < dp.length; i++) {

            Integer max = null;

            for (int j = 0; j < i; j++) {

                if (arr[j] <= arr[i]) {
                    if (max == null) {
                        max = dp[j];
                    } else if (dp[j] > max) {
                        max = dp[j];
                    }
                }

            }
            

            if (max == null) {
                dp[i] = arr[i];
            } else {
                dp[i] = max + arr[i];
            }
            
            if (dp[i] > omax) {
                omax = dp[i];
            }

        }
        System.out.println("Maximum subsequences sum : "+omax);
    }

}
