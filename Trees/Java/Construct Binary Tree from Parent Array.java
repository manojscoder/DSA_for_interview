// Problem link: https://www.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array/1
// Time: O(n)
// Space: O(n)
class Solution {
    public Node createTree(int parent[]) {
        Map<Integer, Node> store = new HashMap<>();
        int root = -1;
        
        for(int idx = 0; idx < parent.length; idx++) {
            store.putIfAbsent(parent[idx], new Node(parent[idx]));
            store.putIfAbsent(idx, new Node(idx));
            
            if(parent[idx] == -1) {
                root = idx;
            }
            else {
                if(store.get(parent[idx]).left == null) {
                    store.get(parent[idx]).left = store.get(idx);
                }
                else {
                    store.get(parent[idx]).right = store.get(idx);
                }
            }
        }
        
        return store.get(root);
    }
}
