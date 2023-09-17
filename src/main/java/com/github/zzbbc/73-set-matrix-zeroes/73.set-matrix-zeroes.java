/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Runtime: 1 ms
// Memory Usage: 44 MB
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Index> zerosIndex = new ArrayList<>();

        int matrixRowLength = matrix.length;
        int matrixColumnLength = matrix[0].length;

        for (int i = 0; i < matrixRowLength; i++) {
            for (int j = 0; j < matrixColumnLength; j++) {
                int value = matrix[i][j];
                if (0 == value) {
                    zerosIndex.add(new Index(i, j));
                }
            }
        }

        for (Index index : zerosIndex) {
            int rowIndex = index.getRow();

            Arrays.fill(matrix[rowIndex], 0);

            int columnIndex = index.getColumn();
            for (int i = 0; i < matrixRowLength; i++) {
                matrix[i][columnIndex] = 0;
            }
        }
    }

    static class Index {
        private final int row;
        private final int column;

        public Index(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
// @lc code=end

