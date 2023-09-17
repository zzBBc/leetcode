/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Runtime: 2 ms
// Memory Usage: 44.60 MB
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Index> zerosIndex = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                if (0 == value) {
                    zerosIndex.add(new Index(i, j));
                }
            }
        }

        Set<Integer> columnIndexs = new HashSet<>();
        for (Index index : zerosIndex) {
            int rowIndex = index.getRow();
            Arrays.fill(matrix[rowIndex], 0);

            columnIndexs.add(index.getColumn());
        }

        for (int i = 0; i < matrix.length; i++) {
            for (Integer columnIndex : columnIndexs) {
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

