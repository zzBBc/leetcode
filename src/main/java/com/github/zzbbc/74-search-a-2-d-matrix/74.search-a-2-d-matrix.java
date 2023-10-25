/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start

// Runtime: 0 ms
// Memory Usage: 41 MB
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixLength = matrix.length;

        int[] previousSubMatrix = new int[0];
        for (int i = 0; i < matrixLength; i++) {
            int[] currentSubMatrix = matrix[i];
            if (currentSubMatrix[0] > target) {
                break;
            }

            previousSubMatrix = currentSubMatrix;
        }

        for (int i = 0; i < previousSubMatrix.length; i++) {
            if (target == previousSubMatrix[i]) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

