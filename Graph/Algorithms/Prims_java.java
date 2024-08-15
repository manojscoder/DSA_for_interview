// Time: O(E log E)
// Space: O(E)
public class prims {

    private static void mst(int[][] edges, int num) {
        int[] visit = new int[num + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> mstEdges = new ArrayList<>();
        List<int[]>[]  adjList = new ArrayList[num + 1];
        int cost = 0;

        for(int idx = 0; idx <= num; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(new int[] {edge[1], edge[2]});
            adjList[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        queue.offer(new int[] {0, 0, -1});

        while(!queue.isEmpty()) {
            int[] edge = queue.poll();

            if(visit[edge[1]] == 1) {
                continue;
            }

            if(edge[2] != -1) {
                mstEdges.add(new int[] {edge[1], edge[2]});
            }

            cost += edge[0];
            visit[edge[1]] = 1;

            for(int[] pair : adjList[edge[1]]) {
                queue.offer(new int[] {pair[1], pair[0], edge[1]});
            }
        }

        System.out.println(cost);

        for(int[] pair : mstEdges) {
            System.out.println(Arrays.toString(pair));
        }
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 4, 2}, {3, 2, 2}, {4, 3, 1}};
        mst(edges, 5);
    }
}
