/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

// Runtime: 1 ms
// Memory Usage: 40.60 MB
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            switch (i) {
                case 0:
                    row.add(1);
                    break;
                case 1:
                    row.add(1);
                    row.add(1);
                    break;
                default:
                    List<Integer> previousRow = list.get(i - 1);
                    row.add(1);

                    for (int j = 0; j < previousRow.size() - 1; j++) {
                        row.add(previousRow.get(j) + previousRow.get(j + 1));
                    }

                    row.add(1);
                    break;
            }

            list.add(row);
        }

        return list;
    }
}

// @lc code=end

