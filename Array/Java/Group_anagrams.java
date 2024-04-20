// Time: O(m * n), where m is the length of the given input and n is the average length of every strings in the input list
// Space O(1)
// Problem link: https://leetcode.com/problems/group-anagrams/description/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();

        for(String s : strs){
            int[] map = new int[26];

            for(char c : s.toCharArray()){
                map[c - 'a']++;
            }

            StringBuilder str = new StringBuilder();

            for(int j = 0; j < 26; j++){
                for(int i = 0; i < map[j]; i++){
                    str.append((char)(97 + j));
                }
            }

            String st = str.toString();
            if(!store.containsKey(st)){
                store.put(st, new ArrayList<>());
            }
            store.get(st).add(s);
        }
        return new ArrayList<>(store.values());
    }
}
