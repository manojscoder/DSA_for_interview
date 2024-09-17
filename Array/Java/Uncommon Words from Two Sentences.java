// Problem link: https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
// Time: O(M + N)
// Space: O(M + N)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap();

        for(String word: s1.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        for(String word: s2.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> result = new LinkedList();

        for(String word: count.keySet())
            if (count.get(word) == 1)
                result.add(word);

        return result.toArray(new String[result.size()]);
    }
}
