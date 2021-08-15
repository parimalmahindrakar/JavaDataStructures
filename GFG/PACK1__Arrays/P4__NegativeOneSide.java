package PACK1__Arrays;

public class P4__NegativeOneSide {


    public static void main(String[] args) {
        
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        System.out.print("Simple array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        int temp, j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i]; // capturing this -ve value 
                    arr[i] = arr[j]; // placing the jth +ve value to ith place.
                    arr[j] = temp; // placing ith place value to jth place.
                }
                j++;
            }
        }
        System.out.print("One sided array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
    
}
