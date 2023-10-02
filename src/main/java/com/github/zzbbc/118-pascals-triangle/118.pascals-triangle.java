/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    private final Map<Calculate, Integer> valueMap = new HashMap<>();

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
                        row.add(getOrPutValueMap(previousRow.get(j), previousRow.get(j + 1)));
                    }

                    row.add(1);
                    break;
            }

            list.add(row);
        }

        return list;
    }

    private Integer getOrPutValueMap(int num1, int num2) {
        Calculate calculate = new Calculate(num1, num2);

        Integer value = valueMap.get(calculate);
        if (Objects.isNull(value)) {
            value = num1 + num2;

            valueMap.put(calculate, value);
        }

        return value;
    }

    static class Calculate {
        private final int num1;
        private final int num2;

        public Calculate(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1() {
            return num1;
        }



        public int getNum2() {
            return num2;
        }



        @Override
        public int hashCode() {
            return Objects.hash(num1, num2);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Calculate other = (Calculate) obj;
            return num1 == other.num1 && num2 == other.num2;
        }


    }
}

// @lc code=end

