// Problem link: https://leetcode.com/problems/largest-number/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public String largestNumber(int[] nums) {
        String[] store = new String[nums.length];
        StringBuilder result = new StringBuilder();

        for(int idx = 0; idx < nums.length; idx++) {
            store[idx] = String.valueOf(nums[idx]);
        }

        Arrays.sort(store, (a, b) -> (b + a).compareTo(a + b));

        if(store[0].equals("0")) {
            return "0";
        }

        for(String str : store) {
            result.append(str);
        }

        return result.toString();
    }
}
