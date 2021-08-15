
public class MaxMinOfArray {

    public static void main(String[] args) {

        int[] arr = { 1, 9, 3, 4, 5, 6, 7, 8, 2 };

        System.out.println(printMin(arr, 0));
        // printMin(arr, 0);
    }

    public static int printMax(int[] arr, int index) {

        if (index == arr.length - 1) {
            return arr[index];
        }

        int misa = printMax(arr, index + 1);
        
        if (misa > arr[index]) {
            return misa;
        } else {

            System.out.println(index);
            return arr[index];

        }

    }

    public static int printMin(int[] arr, int index) {

        if (index == arr.length - 1) {
            return arr[index];
        }

        int misa = printMin(arr, index + 1);
        if (misa < arr[index]) {
            return misa;
        } else {

            return arr[index];

        }

    }

}
