// Problem link: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description
// Time: O(n  + m)
// Space: O(m)
class TrieNode {
    TrieNode[] store;
    boolean isEnd;

    public TrieNode() {
        this.store = new TrieNode[10];
        this.isEnd = false;
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
            if(node.store[chr - '0'] == null) {
                node.store[chr - '0'] = new TrieNode();
            }
            node = node.store[chr - '0'];
        }

        node.isEnd = true;
    }

    public int findLongestPrefix(String word) {
        int count = 0;
        TrieNode node = this.root;

        for(char chr : word.toCharArray()) {
            if(node.store[chr - '0'] == null) {
                return count;
            }
            count += 1;
            node = node.store[chr - '0'];
        }

        return count;
    }
}


class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int result = 0;

        for(int num : arr1) {
            trie.addWord(String.valueOf(num));
        }

        for(int num : arr2) {
            result = Math.max(result, trie.findLongestPrefix(String.valueOf(num)));
        }

        return result;
    }
}
