// Problem link: https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description
// Time: O(n * m)
// Space: O(n * m)
class TrieNode {

    TrieNode[] store;
    int count;

    public TrieNode() {
        this.store = new TrieNode[26];
        this.count = 0;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;

        for(char chr : word.toCharArray()) {
            if(node.store[chr - 'a'] == null) {
                node.store[chr - 'a'] = new TrieNode();
            }
            node.store[chr - 'a'].count++;
            node = node.store[chr - 'a'];
        }

    }

    public int prefixCount(String word) {
        int result = 0;
        TrieNode node = this.root;

        for(char chr : word.toCharArray()) {
            result += node.store[chr - 'a'].count;
            node = node.store[chr - 'a'];
        }

        return result;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] result = new int[words.length];

        for(String str : words) {
            trie.addWord(str);
        }

        for(int idx = 0; idx < words.length; idx++) {
            result[idx] = trie.prefixCount(words[idx]);
        }

        return result;
    }
}
