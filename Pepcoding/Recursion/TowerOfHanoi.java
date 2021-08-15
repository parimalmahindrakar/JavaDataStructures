public class TowerOfHanoi {

    public static void main(String[] args) {

        int n = 3;
        char t1d = 'A';
        char t2d = 'B';
        char t3d = 'C';

        TOH(n, t1d, t2d, t3d);

    }
    

    public static void TOH(int n, char t1d, char t2d, char t3d) {

        if (n == 0) {
            return;
        }

        // n are disks
        // t1d, t2d, t3d are rods

        TOH(n - 1, t1d, t3d, t2d);
        System.out.println( n + "["+t1d+" -> "+t2d+"]");
        TOH(n - 1, t3d, t2d, t1d);

    }
    
}
