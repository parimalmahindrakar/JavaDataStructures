
public class PrintPermutatinos {

    public static void main(String[] args) {
        
        String str = "abc";
        String sf = "";

        printPermutations(str, sf);
    }

    public static void printPermutations(String str, String sf) {

        if (str.length() == 0) {
            System.out.println(sf);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lpart = str.substring(0, i);
            String rpart = str.substring(i + 1);
            String ros = lpart + rpart;
            printPermutations(ros, sf + ch);
        }
        
    }

}
