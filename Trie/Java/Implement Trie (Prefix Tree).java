// Problem link: https://leetcode.com/problems/implement-trie-prefix-tree/description/
// Time: O(n)
// Space: O(n)
class TrieNode {

    TrieNode[] store;
    boolean isEnd;

    public TrieNode() {
        this.store = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = this.root;

        for(char chr : word.toCharArray()) {
            if(node.store[chr - 'a'] == null) {
                node.store[chr - 'a'] = new TrieNode();
            }
            node = node.store[chr - 'a'];
        }

        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = this.root;

        for(char chr : word.toCharArray()) {
            if(node.store[chr - 'a'] == null) {
                return false;
            }
            node = node.store[chr - 'a'];
        }

        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;

        for(char chr : prefix.toCharArray()) {
            if(node.store[chr - 'a'] == null) {
                return false;
            }
            node = node.store[chr - 'a'];
        }

        return true;
    }
}
