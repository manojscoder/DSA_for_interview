// Problem link: https://leetcode.com/problems/single-number-ii/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int[] store = new int[32];
        int result = 0;

        for(int num : nums) {
            for(int pos = 0; pos < 32; pos++) {
                if((num & (1 << pos)) != 0) {
                    store[pos] += 1;
                }
            }
        }

        for(int pos = 0; pos < 32; pos++) {
            store[pos] %= 3;
            if(store[pos] == 1) {
                result |= (1 << pos);
            }
        }

        return (result & (1 << 31)) == 0 ? result : result - (1 << 32);
    }
}
