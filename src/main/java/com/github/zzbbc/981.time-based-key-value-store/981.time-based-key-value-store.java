/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// Runtime:  141ms
// Memory Usage: 108.05MB
class TimeMap {
    private final Map<String, List<Pair>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = timeMap.get(key);

        if (Objects.isNull(pairs) || pairs.isEmpty()) {
            return "";
        }

        return getPairValueByTimestamp(pairs, timestamp);
    }

    private String getPairValueByTimestamp(List<Pair> pairs, int timestamp) {
        int left = 0;
        int right = pairs.size() - 1;

        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (pairs.get(mid).timestamp <= timestamp) {
                result = pairs.get(mid).value;

                left = mid + 1;
            } else {
                right = mid - 1;
            }
            ;
        }

        return result;
    }

    public class Pair {
        private int timestamp;
        private String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
