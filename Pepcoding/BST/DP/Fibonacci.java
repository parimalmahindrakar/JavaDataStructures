
import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int fbnum = sc.nextInt();
        int fibn = fibonacci(fbnum);
        System.out.println("Fibonacci : " + fibn);
        int fibn1 = fibonacciMemoize(fbnum, new int[fbnum + 1]);
        System.out.println("Fibonacci MEM : " + fibn1);
        sc.close();

    }

    public static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int fibnm1 = fibonacci(n - 1);
        int fibnm2 = fibonacci(n - 2);
        int fibn = fibnm1 + fibnm2;

        return fibn;

    }

    public static int fibonacciMemoize(int n, int[] qb) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        System.out.println("Hello : " + n);

        int fibnm1 = fibonacciMemoize(n - 1, qb);
        int fibnm2 = fibonacciMemoize(n - 2, qb);
        int fibn = fibnm1 + fibnm2;

        qb[n] = fibn;
        return fibn;

    }

}