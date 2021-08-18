package PACK3__String;

public class p1__ReverseString {


    public static void main(String[] args) {
        
        String s = "parimal";
        char ch[] = s.toCharArray();
        StringBuffer reversed = new StringBuffer();

        for (int i = ch.length - 1; i >= 0; i--) {
            reversed.append("" + ch[i]);
        }
        System.out.println("Reversed string : " + reversed);
        
        char temp;
        for (int i = 0, j = ch.length - 1; i != j; i++, j--) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

        System.out.print("Reversed string : ");
        for (char c : ch) {
            System.out.print(c + "");
        }
        System.out.println();


    }
    
}
