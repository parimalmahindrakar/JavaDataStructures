
public class DisplayArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        //printing array in general
        System.out.print("In general : ");
        printArrayNotReverse(arr, 0);
        System.out.println();

        //printing array in reverse
        System.out.print("In reverse : ");
        printArrayReverse(arr, arr.length-1);
        System.out.println();

    }
    
    public static void printArrayNotReverse(int[] arr, int index) {

        if (index >= arr.length) {
            return;
        }

        System.out.print(arr[index] + " ");
        printArrayNotReverse(arr, index + 1);

    }
    
    public static void printArrayReverse(int[] arr, int index) {

        if (index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        printArrayReverse(arr, index - 1);

    }
    
}
