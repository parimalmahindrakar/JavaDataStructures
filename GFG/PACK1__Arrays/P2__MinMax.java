package PACK1__Arrays;

public class P2__MinMax {

    public static void main(String[] args) {
        
        int arr[] = { 4, 1, 3, 5, 7, 4, 6, -465642, 999 };
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }


        System.out.println(min+" "+max);


    }
    
}
