// Problem link: https://leetcode.com/problems/count-vowel-strings-in-ranges/description
// Time: O(m + n)
// Space: O(m)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int left, right, prefix[] = new int[words.length + 1], result[] = new int[queries.length];
        String vowels = "aeiou", word;

        for(int index = 0; index < words.length; index++) {
            word = words[index];
            prefix[index + 1] = prefix[index];
            if(vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length() - 1)) != -1) {
                prefix[index + 1]++;
            }
        }

        for(int index = 0; index < queries.length; index++) {
            left = queries[index][0];
            right = queries[index][1];
            result[index] = prefix[right + 1] - prefix[left];
        }

        return result;
    }
}
