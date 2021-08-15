
public class Factorial {
    
    public static void main(String[] args) {

        int num = 10;
        System.out.println("Factorial : "+ factorial(num));;

    }
    /*
    public static int factorial(int num) {

        if(num == 0)  {
            return 1;
        }

        int fnm1 = factorial(num - 1);
        int fn = num * fnm1;
        return fn;

    }

    */


    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }


        int x = factorial(num - 1);
        int mul = num * x;
        return mul;


    }

}
