// Time: O(V + E)
// Space: O(V + E)
public class Kosaraju {

    private static void dfs(int node, List<Integer>[] adjList, int[] visit, List<Integer> store) {
        visit[node] = 1;

        for(int nei : adjList[node]) {
            if(visit[nei] != 1)
                dfs(nei, adjList, visit, store);
        }

        store.add(node);
    }

    private static List<List<Integer>> ssc(int[][] edges, int num) {
        List<Integer> order = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] adjList = new ArrayList[num];
        List<Integer>[] reversedList = new ArrayList[num];
        int[] visit = new int[num];

        for(int idx = 0; idx < num; idx++) {
            adjList[idx] = new ArrayList<>();
            reversedList[idx] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            reversedList[edge[1]].add(edge[0]);
        }

        for(int node = 0; node < num; node++) {
            if(visit[node] != 1) {
                dfs(node, adjList, visit, order);
            }
        }

        Arrays.fill(visit, 0);

        while(!order.isEmpty()) {
            int node = order.remove(order.size() - 1);
            List<Integer> nodes = new ArrayList<>();

            if(visit[node] != 1) {
                dfs(node, reversedList, visit, nodes);
                result.add(nodes);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {4, 7}, {5, 6}, {6, 7}, {6, 4}};
        System.out.println("SCC: "+ ssc(edges, 8));
    }
}
