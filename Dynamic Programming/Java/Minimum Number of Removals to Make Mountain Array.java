// Problem link: https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int result = nums.length, size = nums.length;
        int[] LIS = new int[size], LDS = new int[size];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        for(int pntOne = 0; pntOne < size; pntOne++) {
            for(int pntTwo = 0; pntTwo < pntOne; pntTwo++) {
                if(nums[pntTwo] < nums[pntOne]) {
                    LIS[pntOne] = Math.max(LIS[pntOne], 1 + LIS[pntTwo]);
                }
            }
        }

        for(int pntOne = size - 1; pntOne >= 0; pntOne--) {
            for(int pntTwo = size - 1; pntTwo > pntOne; pntTwo--) {
                if(nums[pntTwo] < nums[pntOne]) {
                    LDS[pntOne] = Math.max(LDS[pntOne], 1 + LDS[pntTwo]);
                }
            }
        }

        for(int index = 1; index < size - 1; index++) {
            if(LIS[index] > 1 && LDS[index] > 1) {
                result = Math.min(result, size - LIS[index] - LDS[index] + 1);
            }
        }

        return result;
    }
}
