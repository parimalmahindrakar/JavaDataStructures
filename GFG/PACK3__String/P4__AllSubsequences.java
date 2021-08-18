package PACK3__String;

import java.util.*;


public class P4__AllSubsequences {


    static List<String> al = new ArrayList<>();


    public static void main(String[] args) {

        String str = "abc";
        findsubsequences(str, "");
        System.out.println(al);

    }

    private static void findsubsequences(String s, String ans) {
        
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }
                                         
    

}
