class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
int n = nums.length;
int[] result = new int[n - k + 1];
Deque<Integer> deque = new ArrayDeque<>(); // stores indices, decreasing values front-to-back
for (int i = 0; i < n; i++) {
while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
deque.pollFirst(); // remove indices that fell out of the window
}
while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
deque.pollLast(); // remove values that can never be a future max
}
deque.offerLast(i);
if (i >= k - 1) {
result[i - k + 1] = nums[deque.peekFirst()];
}
}
return result;
}
    }
