/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
// Runtime: 2 ms
// Memory Usage: 57.58 MB
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int index0 = -1;

        int productAll = 1;
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(0 == value){
                if(index0 != -1){
                    Arrays.fill(nums, 0);

                    return nums;
                } else {
                    index0 = i;
                }
            } else {
                productAll *= value;
            }
        }

        if(-1 != index0){
            Arrays.fill(nums, 0);

            nums[index0] = productAll;
        } else {
            for(int i = 0; i < nums.length; i++){
                nums[i] = productAll/nums[i];
            }
        }

        return nums;
    }
}
// @lc code=end

