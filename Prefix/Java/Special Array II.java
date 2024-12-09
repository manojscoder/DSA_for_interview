// Problem link: https://leetcode.com/problems/special-array-ii/description/
// Time: O(n + m)
// Space: O(m)
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int numsSize = nums.length, queriesSize = queries.length, start, end;
        int[] prefix = new int[numsSize];
        boolean[] result = new boolean[queriesSize];

        for(int index = 1; index < numsSize; index++) {
            if(nums[index] % 2 != nums[index - 1] % 2) {
                prefix[index] = 1;
            }
            prefix[index] += prefix[index - 1];
        }

        for(int index = 0; index < queriesSize; index++) {
            start = queries[index][0];
            end = queries[index][1];

            if(end - start == prefix[end] - prefix[start]) {
                result[index] = true;
            }
        }

        return result;
    }
}
