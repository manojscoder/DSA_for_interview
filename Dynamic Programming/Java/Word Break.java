// Problem link: https://leetcode.com/problems/word-break/description/
// Time: O(n * w) where w is the length of wordDict
// Space: O(n)
class Solution {
    HashMap<String, Boolean> cache;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.cache = new HashMap<>();
        return this.dfs(s, wordDict);
    }

    private boolean dfs(String word, List<String> wordDict){
        if(word.length() == 0)  
            return true;
        else if(this.cache.containsKey(word))   
            return this.cache.get(word);

        for(int i = 0; i < wordDict.size(); i++){
            String substr = wordDict.get(i);
            if(substr.equals(word.substring(0, Math.min(word.length(), substr.length())))){
                if(this.dfs(word.substring(substr.length()), wordDict)){
                    this.cache.put(word, true);
                    return true;
                }
            }
        }

        this.cache.put(word, false);
        return false;
    }
}
