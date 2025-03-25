/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start

// Runtime: 14 ms
// Memory Usage: 45.16 MB
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if(chars[i] != chars[j]){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
// @lc code=end

