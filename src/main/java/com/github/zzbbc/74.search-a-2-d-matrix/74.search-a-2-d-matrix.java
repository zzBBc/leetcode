/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start

// Runtime: 0ms
// Memory Usage: 42.04MB
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] > target) {
                break;
            }

            i = j;
        }

        if (i == -1) {
            return false;
        }

        int index = binarySearch(matrix[i], 0, matrix[0].length - 1, target);

        if (index == -1) {
            return false;
        }

        return true;
    }

    private int binarySearch(int[] matrix, int left, int right, int target) {
        if (left - right >= 0) {
            if (matrix[left] == target) {
                return left;
            }

            return -1;
        }

        int i = left + (right - left) / 2;
        if (matrix[i] == target) {
            return i;
        }

        if (matrix[i] > target) {
            return binarySearch(matrix, left, i - 1, target);
        }

        return binarySearch(matrix, i + 1, right, target);
    }
}
// @lc code=end

