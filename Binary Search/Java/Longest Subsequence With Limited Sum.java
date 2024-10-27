// Problem link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        int left, right, answer, mid;

        for(int idx = 1; idx < nums.length; idx++) {
            nums[idx] += nums[idx - 1];
        }

        for(int idx = 0; idx < queries.length; idx++) {
            answer = -1;
            left = 0;
            right = nums.length - 1;

            while(left <= right) {
                mid = (left + right) / 2;

                if(nums[mid] <= queries[idx]) {
                    answer = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            result[idx] = answer + 1;
        }

        return result;
    }
}
