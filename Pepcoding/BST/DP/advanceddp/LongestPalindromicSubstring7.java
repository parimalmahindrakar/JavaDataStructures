package advanceddp;

import java.util.*;

public class LongestPalindromicSubstring7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = 0;

        for(int g = 0 ; g < dp.length; g++) {
            
            for (int i = 0, j = g; j < dp.length; j++, i++) {

                if (g == 0) 
                    dp[i][j] = true;
                
                else if (g == 1) 
                    dp[i][j] = s.charAt(i) == s.charAt(j);

                else 
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true;

                if (dp[i][j])
                    len = g+1;
            }
            
            

        }

        System.out.println("Palindrome of longest length : " + len);
        sc.close();

    }
}
