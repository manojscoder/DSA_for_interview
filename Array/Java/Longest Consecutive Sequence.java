// Problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        for(int n : nums) {
            numsSet.add(n);
        }
        
        int result = 0, size;

        for(int i = 0; i < nums.length; i++) {
            
            if(!numsSet.contains(nums[i] - 1)) {
                size = 0;

                while(numsSet.contains(nums[i] + size)) {
                    size += 1;
                }

                result = Math.max(size, result);
            }
        }
        return result;
    }
}
