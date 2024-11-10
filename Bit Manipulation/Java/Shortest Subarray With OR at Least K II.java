// Problem link: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int result = nums.length + 1, left = 0, value = 0;
        int[] store = new int[32];

        for(int right = 0; right < nums.length; right++) {

            value |= nums[right];

            for(int pos = 0; pos < 32; pos++) {
                if((nums[right] & (1 << pos)) != 0) {
                    store[pos]++;
                }
            }

            while(left <= right && value >= k) {
                result = Math.min(result, right - left + 1);

                for(int pos = 0; pos < 32; pos++) {
                    if((nums[left] & (1 << pos)) != 0) {
                        store[pos]--;
                        if(store[pos] == 0) {
                            value &= ~(1 << pos);
                        }
                    }
                }
                left++;
            }
        }


        return result == nums.length + 1 ? -1 : result;
    }  
}class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int result = nums.length + 1, left = 0, value = 0;
        int[] store = new int[32];

        for(int right = 0; right < nums.length; right++) {

            value |= nums[right];

            for(int pos = 0; pos < 32; pos++) {
                if((nums[right] & (1 << pos)) != 0) {
                    store[pos]++;
                }
            }

            while(left <= right && value >= k) {
                result = Math.min(result, right - left + 1);

                for(int pos = 0; pos < 32; pos++) {
                    if((nums[left] & (1 << pos)) != 0) {
                        store[pos]--;
                        if(store[pos] == 0) {
                            value &= ~(1 << pos);
                        }
                    }
                }
                left++;
            }
        }


        return result == nums.length + 1 ? -1 : result;
    }  
}
