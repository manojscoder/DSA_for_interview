// Problem link: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public char findKthBit(int n, int k) {
        int size = (int)Math.pow(2, n) - 1, half;
        boolean flag = false;

        while(size > 1) {
            half = size / 2;

            if(half >= k) {
                size = half;
            }
            else if(half + 1 < k) {
                k = 1 + size - k;
                size = half;
                flag = !flag;
            }
            else{
                return flag ? '0' : '1';
            }
        }

        return flag ? '1' : '0';
    }
}
