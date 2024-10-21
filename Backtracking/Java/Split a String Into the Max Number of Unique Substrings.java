// Problem link: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description
// Time: O(n * 2 ^ n)
// Space: O(n)
class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return this.dfs(s, 0, seen);
    }

    private int dfs(String s, int idx, Set<String> seen) {
        if(idx == s.length()) {
            return seen.size();
        }

        int result = 0;

        for(int i = idx; i < s.length(); i++) {
            String strsub = s.substring(idx, i + 1);
            if(!seen.contains(strsub)) {
                seen.add(strsub);
                result = Math.max(result, this.dfs(s, i + 1, seen));
                seen.remove(strsub);
            }
        }

        return result;
    }
}
