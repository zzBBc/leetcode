/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
// Runtime: 15 ms
// Memory Usage: 45.71 MB
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        for(int num: nums){
            Integer count = map.get(num);

            if(count == null){
                map.put(num, 0);
            } else {
                map.put(num, ++count);
            };
        };

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[]{entry.getKey(), entry.getValue()});
        }

        arr.sort((e1, e2) -> - (e1[1] - e2[1]));

        int[] kFrequenceNumber = new int[k];
        for(int i = 0; i < k; i++){
            kFrequenceNumber[i] = arr.get(i)[0];
        };

        return kFrequenceNumber;
    }
}
// @lc code=end

