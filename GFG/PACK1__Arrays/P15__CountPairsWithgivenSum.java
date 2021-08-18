package PACK1__Arrays;

public class P15__CountPairsWithgivenSum {

    public static void main(String[] args) {

        int arr[] = { 1, 4, 3, 2, 2 };
        int sum = 4;

        System.out.println(findsum(arr, sum));

    }
    
    public static int findsum(int[] arr, int sum) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println(arr[i]+" "+arr[j]);
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
}
