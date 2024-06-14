// Problem link: https://leetcode.com/problems/next-permutation/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                for(int j = n - 1; j > i; j--) {
                    if(nums[j] > nums[i]) {
                        nums[i] = nums[i] + nums[j];
                        nums[j] = nums[i] - nums[j];
                        nums[i] = nums[i] - nums[j];
                        break;
                    }
                }
                left = i + 1;
                break;
            }
        }

        while(left < right) {
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left++] - nums[right--];
        }
    }
}
