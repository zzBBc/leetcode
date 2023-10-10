/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
// Runtime: 0 ms
// Memory Usage: 42.09 MB
class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length;

        if (1 == size) {
            return;
        }

        int firstLessThan = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstLessThan = i;
                break;
            }
        }

        if (-1 == firstLessThan) {
            reverseFrom(nums, 0);
        } else {
            int revertIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstLessThan]) {
                    revertIndex = i;
                    break;
                }
            }

            changePosition(nums, firstLessThan, revertIndex);

            reverseFrom(nums, firstLessThan + 1);
        }
    }

    private void changePosition(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverseFrom(int[] nums, int fromIndex) {
        int index = fromIndex;
        int j = nums.length - 1;

        while (index < j) {
            changePosition(nums, index, j);

            index++;
            j--;
        }
    }
}
// @lc code=end

