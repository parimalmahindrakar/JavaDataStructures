
public class Array2DProb2Traversals {

    public static void main(String[] args) {

        int mat[][] = {

                { 1, 2, 3, 4 }, 
                { 2, 3, 4, 5 }, 
                { 5, 6, 7, 8 }, 
                { 3, 2, 4, 5 }, };

        // WaveTraversal(mat);
        SpiralTraversal(mat);

    }

    public static void WaveTraversal(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < mat.length; j++) {
                    System.out.println(mat[j][i]);
                }
            } else {
                for (int j = mat.length - 1; j >= 0; j--) {
                    System.out.println(mat[j][i]);
                }
            }
        }

    }

    public static void SpiralTraversal(int[][] arr) {

        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;

        int tne = arr.length * arr[0].length; // total number of elements
        int cnt = 0;

        while (cnt < tne) {

            // left wall
            for (int i = minr, j = minc; i <= maxr && cnt < tne; i++) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;

            // bottom wall
            for (int i = maxr, j = minc; j <= maxc && cnt < tne; j++) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxr--;

            // right wall
            for (int i = maxr, j = maxc; i >= minr && cnt < tne; i--) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxc--;

            // top wall
            for (int i = minr, j = maxc; j >= minc && cnt < tne; j--) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            minr++;
        }

    }

}
