/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

// Right answer but wrong in leetcode
class Solution {
    private static final Map<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (n > 0) {
            return myPowInternal(x, n);
        } else {
            return 1 / myPowInternal(x, -n);
        }
    }

    private double myPowInternal(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            double powN = 0d;

            if (n % 2 == 1) {
                powN = myPowInternal(x, n / 2 + 1) * myPowInternal(x, n / 2);
            } else {
                powN = myPowInternal(x, n / 2) * myPowInternal(x, n / 2);
            }

            map.put(n, powN);

            return powN;
        }
    }
}
// @lc code=end

