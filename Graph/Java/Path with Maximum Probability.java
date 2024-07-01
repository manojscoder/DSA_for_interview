// problem link: https://leetcode.com/problems/path-with-maximum-probability/description/
// Time: O(E log V)
// Space: O(E)
class Pair {
    double prob;
    int node;

    public Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            adjList.putIfAbsent(edges[i][0], new ArrayList<>());
            adjList.putIfAbsent(edges[i][1], new ArrayList<>());

            adjList.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        maxHeap.add(new Pair(start_node, 1.0));
        Set<Integer> visit = new HashSet<>();

        while(!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            visit.add(pair.node);
            
            if(end_node == pair.node)
                return pair.prob;
            
            if(adjList.containsKey(pair.node)) {
                for(Pair curr : adjList.get(pair.node)) {
                    if(!visit.contains(curr.node)) {
                        maxHeap.add(new Pair(curr.node, pair.prob * curr.prob));
                    }
                }
            }
        }

        return 0.0;
    }
}
