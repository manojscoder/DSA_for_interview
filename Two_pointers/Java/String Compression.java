// Problem link: https://leetcode.com/problems/string-compression/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int compress(char[] chars) {
        int count = 1, index = 0, size = chars.length;

        for(int idx = 1; idx <= size; idx++) {
            if(idx == size || chars[idx] != chars[idx - 1]) {
                chars[index++] = chars[idx - 1];

                if(count > 1) {
                    for(char chr : String.valueOf(count).toCharArray()) {
                        chars[index++] = chr;
                    }
                }
                count = 0;
            }
            count++;
        }

        return index;
    }
}
