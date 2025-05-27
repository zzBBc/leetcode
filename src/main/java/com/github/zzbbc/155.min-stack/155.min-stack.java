/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.LinkedList;

// Runtime: 4 ms
// Memory Usage: 45.51 MB
class MinStack {
    private LinkedList<int[]> linkedList;

    public MinStack() {
        linkedList = new LinkedList<>();
    }

    public void push(int val) {
        int currentMin = linkedList.isEmpty() ? val : Math.min(val, this.getMin());

        linkedList.addFirst(new int[] { val, currentMin });
    }

    public void pop() {
        linkedList.removeFirst();
    }

    public int top() {
        return linkedList.getFirst()[0];
    }

    public int getMin() {
        return linkedList.getFirst()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
