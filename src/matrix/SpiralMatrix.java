package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {


    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        for (int i : spiral) {
            System.out.print(i + " ");
        }

        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> spiral2 = spiralMatrix.spiralOrder(matrix2);
        System.out.println();

        for (int i : spiral2) {
            System.out.print(i + " ");
        }

        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        List<Integer> spiral3 = spiralMatrix.spiralOrder(matrix3);
        System.out.println();

        for (int i : spiral3) {
            System.out.print(i + " ");
        }

    }
    public List<Integer> spiralOrder(int[][] matrix) {

        int maxL = matrix[0].length - 1;
        int minL = 0;
        int maxH = matrix.length - 1;
        int minH = 0;

        List<Integer> order = new ArrayList<>();

        while (minH <= maxH && minL <= maxL) {

            for (int i = minL; i <= maxL; i++) {
                order.add(matrix[minH][i]);
            }
            minH++;

            if (minH > maxH) break;

            for (int i = minH; i <= maxH; i++) {
                order.add(matrix[i][maxL]);
            }
            maxL--;

            if (maxL < minL) break;

            for (int i = maxL; i >= minL; i--) {
                order.add(matrix[maxH][i]);
            }
            maxH--;

            if (maxH < minH) break;

            for (int i = maxH; i >= minH; i--) {
                order.add(matrix[i][minL]);
            }
            minL++;
        }

        return order;
    }
}
