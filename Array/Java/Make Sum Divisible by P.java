// Problem link: https://leetcode.com/problems/make-sum-divisible-by-p/description
// Time: O(n)
// Space: O(n)
vclass Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;

        for(int num : nums) {
            total = (total + num) % p;
        }

        if(total % p == 0) {
            return 0;
        }

        int curr_sum = 0, result = nums.length, remainder = total % p;
        HashMap<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, -1);

        for(int idx = 0; idx < nums.length; idx++) {
            curr_sum = (curr_sum + nums[idx]) % p;
            int prefix = (curr_sum - remainder + p) % p;

            if(mapping.containsKey(prefix)) {
                result = Math.min(result, idx - mapping.get(prefix));
            }

            mapping.put(curr_sum, idx);
        }

        return result == nums.length ? -1 : result;
    }
}
