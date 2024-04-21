// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int val = 1, n = nums.length;
        int[] result = new int[n];

        result[0] = nums[0];
        for(int i = 1; i < n; i++){
            result[i] = nums[i] * result[i - 1];
        }
        
        for(int i = n - 1; i > 0; i--){
            result[i] = result[i - 1] * val;
            val *= nums[i];
        }
        result[0] = val;
        return result;
    }
}
