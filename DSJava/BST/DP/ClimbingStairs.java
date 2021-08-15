

public class ClimbingStairs {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(countPaths(10, new int[num+1]));
    }
    
    public static int countPaths(int n , int [] qb) {

        if( n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (qb[n] > 0) {
            return qb[n];
        }
        
        int num1 = countPaths(n - 1, qb);
        int num2 = countPaths(n - 2, qb);
        int num3 = countPaths(n - 3, qb);

        int cp = num1 + num2 + num3;

        qb[n] = cp;
        return cp;

    }


}
