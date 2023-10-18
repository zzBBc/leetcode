/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Runtime: 9 ms
// Memory Usage: 45.7 MB
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> merge = new ArrayList<>();

        int intervalLength = intervals.length;
        for (AtomicInteger i = new AtomicInteger(0); i.get() < intervalLength; i
                .incrementAndGet()) {
            int index = i.get();
            int[] e1 = intervals[index];
            if (index == intervalLength - 1) {
                merge.add(e1);
                break;
            }

            int[] e2 = intervals[index + 1];

            merge.add(mergeInternalRecusive(e1, e2, i, intervals));
        }

        int newLength = merge.size();
        int[][] newArray = new int[newLength][2];
        for (int i = 0; i < newLength; i++) {
            newArray[i] = merge.get(i);
        }

        return newArray;
    }

    private int[] mergeInternalRecusive(int[] e1, int[] e2, AtomicInteger index,
            int[][] intervals) {
        if (Math.max(e1[0], e2[0]) <= Math.min(e1[1], e2[1])) {
            int[] mergeInternal = new int[2];
            mergeInternal[0] = Math.min(e1[0], e2[0]);
            mergeInternal[1] = Math.max(e1[1], e2[1]);

            if (index.incrementAndGet() == intervals.length - 1) {
                return mergeInternal;
            }

            return mergeInternalRecusive(mergeInternal, intervals[index.get() + 1], index,
                    intervals);
        } else {
            return e1;
        }
    }
}
// @lc code=end

