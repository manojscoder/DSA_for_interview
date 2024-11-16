// Problem link: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }

        int counter = 1;
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);

        for(int index = 0; index + 1 < nums.length; index++) {
            if(nums[index] + 1 == nums[index + 1]) {
                counter++;
            }
            else {
                counter = 1;
            }

            if(counter >= k) {
                result[index - k + 2] = nums[index + 1];
            }
        }

        return result;
    }
}
