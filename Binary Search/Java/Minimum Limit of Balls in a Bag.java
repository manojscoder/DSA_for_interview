// Problem link: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description
// Time: O(n * log n)
// Space: O(1)
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int result = 0, left = 1, right = 0, mid;

        for(int num : nums) {
            right = Math.max(right, num);
        }

        while(left <= right) {
            mid = (left + right) / 2;

            if(this.canDivide(nums, mid, maxOperations)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

        }

        return result;
    }

    private boolean canDivide(int[] nums, int maxBalls, int maxOperations) {
        int count = 0;

        for(int num : nums) {
            count += (int) (Math.ceil((double)num / maxBalls) - 1);
            
            if(count > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
