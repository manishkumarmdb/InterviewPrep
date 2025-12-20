package interview.asked;

public class MatrixConnectionCounter {
    public static int countConnections(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        // Loop through each element in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the element is 1, check for available adjacent positions
                if (matrix[i][j] == 1) {
                    // Check for horizontal, vertical, and diagonal positions
                    if (j - 1 >= 0 && matrix[i][j - 1] == 1) count++;
                    if (i - 1 >= 0 && matrix[i - 1][j] == 1) count++;
                    if (i + 1 < m && matrix[i + 1][j] == 1) count++;
                    if (j + 1 < n && matrix[i][j + 1] == 1) count++;
                    if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] == 1) count++;
                    if (i - 1 >= 0 && j + 1 < n && matrix[i - 1][j + 1] == 1) count++;
                    if (i + 1 < m && j - 1 >= 0 && matrix[i + 1][j - 1] == 1) count++;
                    if (i + 1 < m && j + 1 < n && matrix[i + 1][j + 1] == 1) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 0, 1}
        };

        System.out.println(countConnections(matrix)); // Output: 7
    }

}
