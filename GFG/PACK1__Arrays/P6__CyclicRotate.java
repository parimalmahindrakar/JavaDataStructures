package PACK1__Arrays;

public class P6__CyclicRotate {

    public static void main(String[] args) {

        int arr[] = { 999, 1, 2, 3, 4, 5,888 };
        int i = 0, j = arr.length - 1;
        while(i != j){
        
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
       }
        
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();


    }
    
}
