// problem link: https://leetcode.com/problems/evaluate-division/description/
// Time: O(E + Q * (V + E))
// Space: O(V + E)
class Pair {

    String node;
    double val;

    public Pair(String node, double val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjList = new HashMap<>();

        for(int idx = 0; idx < values.length; idx++) {
            adjList.putIfAbsent(equations.get(idx).get(0), new ArrayList<>());
            adjList.putIfAbsent(equations.get(idx).get(1), new ArrayList<>());

            adjList.get(equations.get(idx).get(0)).add(new Pair(equations.get(idx).get(1), values[idx]));
            adjList.get(equations.get(idx).get(1)).add(new Pair(equations.get(idx).get(0), 1 / values[idx]));
        }

        double[] result = new double[queries.size()];

        for(int idx = 0; idx < queries.size(); idx++) {
            result[idx] = this.bfs(queries.get(idx).get(0), queries.get(idx).get(1), adjList); 
        }

        return result;
    }

    private double bfs(String nodeOne, String nodeTwo, Map<String, List<Pair>> adjList) {
        if((!adjList.containsKey(nodeOne)) || (!adjList.containsKey(nodeTwo))) {
            return -1.0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.offer(new Pair(nodeOne, 1.0));

        while(!queue.isEmpty()) {
            Pair detail = queue.poll();

            if(detail.node.equals(nodeTwo)) {
                return detail.val;
            }
            else if(visit.contains(detail.node)) {
                continue;
            }

            visit.add(detail.node);

            for(Pair nei : adjList.get(detail.node)) {
                queue.offer(new Pair(nei.node, detail.val * nei.val));
            }
        }

        return -1.0;
    }
}
