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
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        Set<Integer> visit = new HashSet<>();
        int[] dist = new int[n + 1];
        int u, v, time, result = -1;

        for(int i = 0; i < times.length; i++) {
            u = times[i][0];
            v = times[i][1];
            time = times[i][2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new Pair(time, v));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        minHeap.add(new Pair(0, k));

        while(!minHeap.isEmpty()) {
            Pair temp = minHeap.poll();

            if(visit.contains(temp.node))
                continue;
            visit.add(temp.node);

            if(adjList.containsKey(temp.node)) {
                for(Pair store : adjList.get(temp.node)) {
                    if(store.time + temp.time < dist[store.node]) {
                        dist[store.node] = store.time + temp.time;
                        minHeap.add(new Pair(store.time + temp.time, store.node));
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            result = Math.max(result, dist[i]);
        }
        
        return result;
    }
}
