// Problem link: https://leetcode.com/problems/ugly-number-ii/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int two = 0, three = 0, five = 0, num;
        int[] result = new int[n];
        result[0] = 1;

        for(int idx = 1; idx < n; idx++) {
            num = Math.min(2 * result[two], Math.min(3 * result[three], 5 * result[five]));
            result[idx] = num;

            if(2 * result[two] == result[idx]) {
                two++;
            }
            if(3 * result[three] == result[idx]) {
                three++;
            }
            if(5 * result[five] == result[idx]) {
                five++;
            }
        }
        return result[n - 1];
    }
}
