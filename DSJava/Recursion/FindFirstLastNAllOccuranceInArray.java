
public class FindFirstLastNAllOccuranceInArray {

    public static void main(String[] args) {

        int[] arr = { 1, 9, 3, 4, 9, 6, 7, 8, 2, 9 };
        System.out.println("First occurance of 9 : " + findFirstOccurance(arr, 0, 9));
        System.out.println("Last occurance of 9 : " + findLastOccurance(arr, 0, 9));
        int[] newarr = findAllOccurances(arr, 9, 0, 0);
        System.out.print("All occurances : [");
        for (int i : newarr) {
            System.out.print(" "+i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static int findFirstOccurance(int[] arr, int index, int num) {

        if (index >= arr.length) {
            return -1;
        }

        int fiisa = findFirstOccurance(arr, index + 1, num);
        if (arr[index] == num) {
            return index;
        } else {
            return fiisa;
        }

    }

    public static int findLastOccurance(int[] arr, int index, int x) {

        if (index >= arr.length) {
            return -1;
        }

        int liisa = findLastOccurance(arr, index + 1, x);
        if (liisa == -1) {
            if (arr[index] == x) {
                return index;
            } else {
                return -1;
            }
        } else {
            return liisa;
        }
    }


    // fsf is found so far !
    public static int[] findAllOccurances(int arr[], int x, int index, int fsf) {

        if (index == arr.length) {
            return new int[fsf];
        }

        if(arr[index] == x) {
            int[] iarray = findAllOccurances(arr, x, index + 1, fsf + 1);
            iarray[fsf] = index;
            return iarray;
        } else {
            int[] iarray = findAllOccurances(arr, x, index + 1, fsf);
            return iarray;
        }

    }

}
