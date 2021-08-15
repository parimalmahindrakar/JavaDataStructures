
public class Array2DProb1MatrixMultiplication {

    public static void main(String[] args) {

        int mat1[][] = { { 1, 2, 3 }, { 3, 4, 5 }, { 4, 5, 6 } };
        int mat2[][] = { { 1, 2 }, { 3, 4 }, { 4, 5 } };

        System.out.println("\nMat 1 :");
        System.out.println("-------------------");
        for (int arr[] : mat1) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }


        System.out.println("\nMat 2 :");
        System.out.println("-------------------");

        for (int arr[] : mat2) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int matRes[][] = Multiplication(mat1, mat2);



        System.out.println("\nResult :");
        System.out.println("-------------------");

        for (int arr[] : matRes) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();


    }

    public static int[][] Multiplication(int[][] mat1, int[][] mat2) {

        int[][] result = new int[mat1.length][mat2[0].length];


        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                for (int k = 0; k < mat1.length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }

}
