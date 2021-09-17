package PACK1__Arrays;

public class P7__MaxSubArraySum {

    public static void main(String[] args) {
        int arr[] = { -5, 4, 6, -3, 4, -1 };
        System.out.println(maxSubArray(arr));
    }
    

    public static int maxSubArray(int a[]) {
        
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max = 0;

        for (int i = 0; i < size; i++) {
            max += a[i];
            if (max_so_far < max) {
                max_so_far = max;
            }
            if (max < 0) {
                max = 0;
            }
        }
        
        return max_so_far;

    }



}


/**int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max = 0;

        for (int i = 0; i < size; i++) {
            max += a[i];
            if (max_so_far < max) {
                max_so_far = max;
            }
            if (max < 0) {
                max = 0;
            }
        }

        return max_so_far; */