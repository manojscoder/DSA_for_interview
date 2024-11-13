// Problem link: https://leetcode.com/problems/count-the-number-of-fair-pairs/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long result = 0, largest, smallest;
        Arrays.sort(nums);

        for(int index = 0; index < nums.length; index++) {
            largest = this.binarySearch(nums, index, upper - nums[index] + 1);
            smallest = this.binarySearch(nums, index, lower - nums[index]);

            result += largest - smallest;
        }

        return result;
    }

    private int binarySearch(int[] nums, int index, int target) {
        int left = index + 1, right = nums.length - 1, mid;

        while(left <= right) {
            mid = (left + right) / 2;

            if(nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}
