// Problem link: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
// Time: O(n * l)
// Space: O(n * l)
class TrieNode {
    HashMap<String, TrieNode> store;
    boolean isEnd;

    public TrieNode() {
        this.store = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String[] folder) {
        TrieNode node = this.root;

        for(String fold : folder) {
            if(!node.store.containsKey(fold)) {
                node.store.put(fold, new TrieNode());
            }
            node = node.store.get(fold);
        }

        node.isEnd = true;
    }

    public boolean search(String[] folder) {
        TrieNode node = this.root;

        for(String fold : folder) {
            if(node.isEnd) {
                return false;
            }
            node = node.store.get(fold);
        }

        return true;
    }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();

        for(String fold : folder) {
            trie.add(fold.split("/"));
        }

        for(String fold : folder) {
            if(trie.search(fold.split("/"))) {
                result.add(fold);
            }
        }

        return result;
    }
}
