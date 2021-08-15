package advanceddp;

import java.util.*;

public class CountPalindromicSubstrings6 {
    /*
     * You are given a string, you are req to print the count of palindromic
     * substrings in string str.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;

        for(int g = 0 ; g < dp.length; g++) {
            
            for (int i = 0, j = g; j < dp.length; j++, i++) {

                if (g == 0) 
                    dp[i][j] = true;
                
                else if (g == 1) 
                    dp[i][j] = s.charAt(i) == s.charAt(j);

                else 
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true;

                if (dp[i][j])
                    count++;
            }
            
            

        }

        System.out.println("Total palindromes are : " + count);
        sc.close();

    }

}
