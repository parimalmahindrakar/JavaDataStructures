
public class JosephusProblem {

    public static int JosephusSolution(int n, int k) {

        if (n == 1) {
            return 0;
        }

        int x = JosephusSolution(n - 1, k);
        int y = (x + k) % n;
        return y;

    }

    public static void main(String[] args) {
        int n = 9;
        int k = 4;
        System.out.println(JosephusSolution(n, k));
    }

}
