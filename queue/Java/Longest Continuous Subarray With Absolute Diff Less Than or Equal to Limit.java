// Problem link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?
// Time: O(n)
// Space: O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        int left = 0, result = 0;

        for(int right = 0; right < nums.length; right++) {
            while(!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.pollLast();
            }

            minQ.offerLast(nums[right]);

            while(!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.pollLast();
            }

            maxQ.offerLast(nums[right]);

            while(maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if(maxQ.peekFirst() == nums[left])
                    maxQ.pollFirst();
                
                if(minQ.peekFirst() == nums[left])
                    minQ.pollFirst();

                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
