
public class PrintIncreasingDreasing {
    

    public static void main(String[] args) {
        
        int num = 18;
        printDreasing(num);
    }

    public static void printDreasing(int n) {

        if (n < 0) {
            return;
        }

        System.out.println(n);
        printDreasing(n - 1);

    }
    
    public static void printIncreasing(int n) {

        if (n < 0) {
            return;
        }

        printDreasing(n - 1);
        System.out.println(n);

    }

    public static void printIncreasingDecreasing(int n) {

        if (n < 0) {
            return;
        }
        
        System.out.println(n);
        printDreasing(n - 1);
        System.out.println(n);

    }

    

}