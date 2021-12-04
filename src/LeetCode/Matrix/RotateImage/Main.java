package LeetCode.Matrix.RotateImage;

public class Main {

    public static void main(String[] args) {

        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

    }

    public static void rotate(int[][] matrix) {

        int row = matrix.length, col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int left = 0, right = matrix.length -1;

        while (left < right) {

            for (int i = 0; i < row; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }

            left++;
            right--;
        }

    }

}
