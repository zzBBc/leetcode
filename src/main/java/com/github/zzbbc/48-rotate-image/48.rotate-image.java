/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Runtime: 4 ms
// Memory Usage: 41.15 MB
class Solution {
    private static List<CellColumn> swapped;

    public void rotate(int[][] matrix) {
        int length = matrix.length;

        swapped = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (swapped.size() == length * length) {
                    break;
                }

                CellColumn cellColumn = new CellColumn(i, j);
                if (swapped.contains(cellColumn)) {
                    continue;
                }

                swapKeepValue(matrix, matrix[i][j], i, j, swapped);
            }
        }
    }

    private void swapKeepValue(int[][] matrix, int keepValue, int keepRow, int keepColumn,
            List<CellColumn> swapped) {
        int length = matrix.length;
        if (swapped.size() == length * length) {
            return;
        }

        CellColumn cellColumn = new CellColumn(keepRow, keepColumn);
        if (swapped.contains(cellColumn)) {
            return;
        }

        swapped.add(cellColumn);
        int newKeepRow = keepColumn;
        int newKeepColumn = length - 1 - keepRow;
        int newKeepValue = matrix[newKeepRow][newKeepColumn];

        matrix[newKeepRow][newKeepColumn] = keepValue;

        swapKeepValue(matrix, newKeepValue, newKeepRow, newKeepColumn, swapped);
    }

    private static class CellColumn {
        private final int keepRow;
        private final int keepColumn;

        public CellColumn(int keepRow, int keepColumn) {
            this.keepRow = keepRow;
            this.keepColumn = keepColumn;
        }

        @Override
        public int hashCode() {
            return Objects.hash(keepRow, keepColumn);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CellColumn other = (CellColumn) obj;
            return keepRow == other.keepRow && keepColumn == other.keepColumn;
        }


    }
}
// @lc code=end

