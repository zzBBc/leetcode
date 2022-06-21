// Runtime: 51 ms
// Memory Usage: 37.5 MB
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            for (int j = 1; j < numsLength; j++) {
                if (i != j)
                    if (nums[i] + nums[j] == target)
                        return new int[] {i, j};
            }
        }
        return new int[] {};
    }
}
