package PACK3__String;

public class P2__IsPalindrome {

    public static void main(String[] args) {

        String str = "naman";
        int flag = 0;

        for (int i = 0, j = str.length() - 1; i != j; i++, j--) {
            if (str.charAt(i) == str.charAt(j)) {
                flag = 1;
            } else {
                break;
            }
        }
        if(flag == 0)
            System.out.println("Not palindrome");
        else 
         System.out.println("Palindrome");


    }
    
}
