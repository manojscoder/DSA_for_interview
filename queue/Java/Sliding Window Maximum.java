// Problem link: https://leetcode.com/problems/sliding-window-maximum/
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int left = 0, idx = 0;

        for(int right = 0; right < nums.length; right++) {

            while(!queue.isEmpty() && queue.peekLast() < nums[right])
                queue.pollLast();
            
            queue.offerLast(nums[right]);

            if(right - left + 1 == k) {
                result[idx++] = queue.peekFirst();

                if(nums[left] == queue.peekFirst()) {
                    queue.pollFirst();
                }
                left++;
            }
        }

        return result;

    }
}
