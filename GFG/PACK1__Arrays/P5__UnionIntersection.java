package PACK1__Arrays;

public class P5__UnionIntersection {

    public static void main(String[] args) {
        
        int arr1[] = { 1, 1, 2, 3, 4, 5 };
        int arr2[] = { 1, 2, 6, 6, 3 };
        int m = arr1.length;
        int n = arr2.length;


        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i++]+" ");
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j++]+" ");
            } else {
                System.out.print(arr1[i++] + " ");
                j++;
            }
        }

        while (i < m) {
            System.out.print(arr1[i]+ " ");
            i++;
        }

        while (j < n) {
            System.out.print(arr2[j]+ " ");
            j++;
        }



        System.out.println();
    }
    
}
