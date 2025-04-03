/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
// Runtime: 2 ms
// Memory Usage: 47.31 MB
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if(target == sum){
                break;
            }

            if(sum > target){
                j--;
                continue;
            }

            if(sum < target){
                i++;
                continue;
            }
        }

        return new int[]{i+1, j+1};
    }
}
// @lc code=end

