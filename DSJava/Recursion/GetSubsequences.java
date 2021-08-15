
import java.util.*;

public class GetSubsequences {

    public static void main(String[] args) {

        String str = "abc";
        ArrayList<String> res = getSubsequences(str);
        System.out.println(res);

    }

    public static ArrayList<String> getSubsequences(String str) {

        if (str.length() == 0) {

            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        char c = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getSubsequences(ros);

        ArrayList<String> mres = new ArrayList<>();

        for (String rstr : rres) {
            mres.add("" + rstr);
            mres.add(c + rstr);
        }



        return mres;
    }

}
