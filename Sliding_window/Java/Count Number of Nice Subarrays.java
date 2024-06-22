// Problem link: https://leetcode.com/problems/count-number-of-nice-subarrays/description/?
// Time: O(n)
// Space: O(1)class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, left = 0, middle = 0, odd = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] % 2 == 1)
                odd++;
            
            while(odd > k) {
                if(nums[left] % 2 == 1)
                    odd--;
                left++;
                middle = left;
            }

            if(odd == k) {
                while(nums[middle] % 2 == 0) {
                    middle++;
                }
                result += middle - left + 1;
            }
        }

        return result;
    }
}
