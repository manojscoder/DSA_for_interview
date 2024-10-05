// Problem link: https://leetcode.com/problems/permutation-in-string/description
// Time: O(26 * m + n)
// Space: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] storeOne = new int[26];
        int[] storeTwo = new int[26];
        int sizeOne = s1.length(), sizeTwo = s2.length();

        for(char chr : s1.toCharArray()) {
            storeOne[chr - 'a']++;
        }

        for(int idx = 0; idx < sizeTwo; idx++) {
            storeTwo[s2.charAt(idx) - 'a']++;

            if(idx >= sizeOne) {
                storeTwo[s2.charAt(idx - sizeOne) - 'a']--;
            }

            if(Arrays.equals(storeOne, storeTwo)) {
                return true;
            }
        }

        return false;
    }
}
