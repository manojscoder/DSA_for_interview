// Problem link: https://leetcode.com/problems/concatenated-words/description/
// Time: O(n * L ^ 3) where L is the length of the word
// Space: O(n)
class Solution {
    HashMap<String, Boolean> cache;
    HashSet<String> wordsSet;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.cache = new HashMap<>();
        this.wordsSet = new HashSet<>(Arrays.asList(words));

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(dfs(words[i])){
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean dfs(String word){
        if(this.cache.containsKey(word)){
            return this.cache.get(word);
        }
        for(int i = 1; i < word.length(); i++){
            String prefix = word.substring(0, i), suffix = word.substring(i, word.length());
            if(this.wordsSet.contains(prefix) && (this.wordsSet.contains(suffix) || dfs(suffix))){
                this.cache.put(word, true);
                return true;
            }
        }
        this.cache.put(word, false);
        return false;
    }
}
