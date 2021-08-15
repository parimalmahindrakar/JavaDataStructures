
public class FloodFill {

    public static void main(String[] args) {

        int[][] arr = {

                {0,1,1},
                {0,0,1},
                {1,0,0},
                {0,1,0}
        };

        boolean[][] visited = new boolean[4][3];

        floodfill(arr, 0, 0, "", visited);

    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {

        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || visited[row][col] == true) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;

        floodfill(maze, row - 1, col, psf + "t", visited);
        floodfill(maze, row, col - 1, psf + "l", visited);
        floodfill(maze, row + 1, col, psf + "d", visited);
        floodfill(maze, row, col + 1, psf + "r", visited);

        visited[row][col] = false;

    }

}
