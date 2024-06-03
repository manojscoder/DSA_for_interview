// Problem link: https://leetcode.com/problems/all-paths-from-source-to-target/description/
// Time: O(2 ^ V * V)
// Space: O(2 ^ V * V)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Pair<Integer, List<Integer>>> stack = new Stack<>();
        stack.push(new Pair<>(0, new ArrayList<>()));
        stack.peek().getValue().add(0);

        while(!stack.isEmpty()) {
            Pair<Integer, List<Integer>> pair = stack.pop();

            if(pair.getKey() == graph.length - 1) {
                result.add(new ArrayList<>(pair.getValue()));
            }
            else {
                for(int i = 0; i < graph[pair.getKey()].length; i++) {
                    List<Integer> paths = new ArrayList<>(pair.getValue());
                    paths.add(graph[pair.getKey()][i]);
                    stack.push(new Pair<>(graph[pair.getKey()][i], paths));
                }
            }
        }

        return result;
    }
}
