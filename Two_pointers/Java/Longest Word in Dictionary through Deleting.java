// Problem link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
// Time: O(n * (m + k))
// Space: O(max(m, k))
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String word : dictionary) {
            if (isSub(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }

    private boolean isSub(String word, String s) {
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (idx < word.length() && word.charAt(idx) == c) {
                idx++;
            }
        }

        return idx == word.length();
    }
}
