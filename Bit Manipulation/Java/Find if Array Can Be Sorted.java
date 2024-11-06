// Problem link: https://leetcode.com/problems/find-if-array-can-be-sorted/description
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean canSortArray(int[] nums) {
        int currMin = nums[0], currMax = nums[0], prevMax = 0;

        for(int num : nums) {
            if(this.countBits(num) == this.countBits(currMax)) {
                currMin = Math.min(currMin, num);
                currMax = Math.max(currMax, num);
            }
            else {
                if(currMin < prevMax) {
                    return false;
                }
                prevMax = currMax;
                currMin = currMax = num;
            }
        }

        return !(currMin < prevMax);
    }

    private int countBits(int num) {
        int count = 0;

        while(num > 0) {
            if((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }

        return count;
    }
}
