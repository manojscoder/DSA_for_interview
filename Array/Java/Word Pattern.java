// Problem link: https://leetcode.com/problems/word-pattern/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length()) {
            return false;
        }

        Map<String, Character> store_1 = new HashMap<>();
        Map<Character, String> store_2 = new HashMap<>();

        for(int idx = 0; idx < pattern.length(); idx++) {
            char chr = pattern.charAt(idx);
            if(store_1.containsKey(words[idx]) && store_1.get(words[idx]) != chr) {
                return false;
            }

            if(store_2.containsKey(chr) && !store_2.get(chr).equals(words[idx])) {
                return false;
            }

            store_1.put(words[idx], chr);
            store_2.put(chr, words[idx]);
        }

        return true;
    }
}
