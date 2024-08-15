// Time: O(V log E)
// Space: O(V)
public class Dijkstras {
    private static int[] minDist(int[][] edges, int num, int source) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]>[] adjList = new ArrayList[num];
        int[] dist = new int[num];
        int[] visit = new int[num];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int idx = 0; idx < num; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(new int[] {edge[1], edge[2]});
            adjList[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        dist[source] = 0;
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();

            if(visit[pair[1]] == 1) {
                continue;
            }

            visit[pair[1]] = 1;

            for(int[] edge : adjList[pair[1]]) {
                if(pair[0] + edge[1] < dist[edge[0]]) {
                    dist[edge[0]] = pair[0] + edge[1];
                    queue.offer(new int[] {dist[edge[0]], edge[0]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 4}, {0, 2, 4}, {1, 2, 2}, {2, 3, 3}, {2, 4, 1}, {2, 5, 6}, {3, 5, 2}, {4, 5, 3}};
        System.out.println(Arrays.toString(minDist(edges, 6, 0)));
    }
}
