// Problem link: https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
// Time: O(n * log n)
// Space: O(n)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1], mid, count;

        while(left < right) {
            mid = left + (right - left) / 2;
            count = 0;

            for(int pointerTwo = 1, pointerOne = 0; pointerTwo < nums.length; pointerTwo++) {
                while(nums[pointerTwo] - nums[pointerOne] > mid) {
                    pointerOne++;
                }
                count += pointerTwo - pointerOne;
            }

            if(count < k) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}
