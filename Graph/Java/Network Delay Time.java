// Problem link: https://leetcode.com/problems/network-delay-time/description/

// Approach 1: Dijkstras
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


// Approach 2: Bellman ford
// Time: O(E * V)
// Space: O(V)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];

        for(int i = 0; i <= n; i++) 
            dist[i] = Integer.MAX_VALUE;
        dist[k] = 0;
        int u, v, time, result = -1;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < times.length; j++) {
                u = times[j][0];
                v = times[j][1];
                time = times[j][2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + time < dist[v])
                    dist[v] = dist[u] + time;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            result = Math.max(result, dist[i]);
        }

        return result;
    }
}
