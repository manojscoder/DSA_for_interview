// Problem link: https://leetcode.com/problems/course-schedule/description/

// Approach: 1 (DFS)
// Time: O(n + e)
// Space: O(n + e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] visit = new int[numCourses];
        int[] path = new int[numCourses];

        for(int idx = 0; idx < numCourses; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] pair : prerequisites) {
            adjList[pair[0]].add(pair[1]);
        }


        for(int idx = 0; idx < numCourses; idx++) {
            if(this.dfs(idx, visit, path, adjList)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int[] visit, int[] path, List<Integer>[] adjList) {
        if(path[node] == 1) {
            return true;
        }
        else if(visit[node] == 1) {
            return false;
        }

        visit[node] = path[node] = 1;

        for(int v : adjList[node]) {
            if(this.dfs(v, visit, path, adjList)) {
                return true;
            }
        }

        path[node] = 0;
        return false;
    }

}


// Approach: 2 (BFS)
// Time: O(n + e)
// Space: O(n + e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = 0, node;

        for(int idx = 0; idx < numCourses; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] pair : prerequisites) {
            adjList[pair[0]].add(pair[1]);
            indegree[pair[1]] += 1;
        }

        for(int idx = 0; idx < numCourses; idx++) {
            if(indegree[idx] == 0) {
                queue.offer(idx);
                count += 1;
            }
        }

        while(!queue.isEmpty()) {
            node = queue.poll();

            for(int ver : adjList[node]) {
                indegree[ver] -= 1;
                if(indegree[ver] == 0) {
                    queue.offer(ver);
                    count += 1;
                }
            }
        }

        return count == numCourses;
    }
}
