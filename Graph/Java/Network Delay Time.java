// Problem link: https://leetcode.com/problems/network-delay-time/description/
// Time: O(E log V)
// Space: O(V + E)
class Pair {
    int time, node;

    public Pair(int time, int node) {
        this.time = time;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        int u, v, t, result = 0;

        for(int i = 0; i < times.length; i++) {
            u = times[i][0];
            v = times[i][1];
            t = times[i][2];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new Pair(t, v));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        Set<Integer> visit = new HashSet<>();
        minHeap.add(new Pair(0, k));

        while(!minHeap.isEmpty()) {
            Pair temp = minHeap.poll();

            if(visit.contains(temp.node))
                continue;
            visit.add(temp.node);
            result = Math.max(result, temp.time);

            if(adjList.containsKey(temp.node)) {
                for(Pair pair : adjList.get(temp.node)) {
                    if(!visit.contains(pair.node)) {
                        minHeap.add(new Pair(temp.time + pair.time, pair.node));
                    }
                }
            }
        }

        if(visit.size() == n)
            return result;
        return -1;

    }
}
