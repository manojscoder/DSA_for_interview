// Problem link: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
// Time: O(n)
// Space: O(height of the tree)
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
        
        dfs(root, result, lst);
        
        return result;
    }
    
    private static void dfs(Node node, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> lst) {
        if (node != null && node.left == null && node.right == null) {
            lst.add(node.data);
            result.add(new ArrayList<>(lst));
            lst.remove(lst.size() - 1);
        } else if (node != null) {
            lst.add(node.data);
            dfs(node.left, result, lst);
            dfs(node.right, result, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
