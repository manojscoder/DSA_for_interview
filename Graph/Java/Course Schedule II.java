// Problem link: https://leetcode.com/problems/course-schedule-ii/description/

// Approach: 1 (DFS)
// Time: O(n + e)
// Space: O(n + e)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] result = new int[numCourses];
        int[] visit = new int[numCourses + 1], path = new int[numCourses];

        for(int idx = 0; idx < numCourses; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] pair : prerequisites) {
            adjList[pair[0]].add(pair[1]);
        }

        for(int idx = 0; idx < numCourses; idx++) {
            if(this.dfs(idx, visit, path, result, adjList)) {
                return new int[] {};
            }
        }

        return result;
    }

    private boolean dfs(int node, int[] visit, int[] path, int[] result, List<Integer>[] adjList) {
        if(path[node] == 1) {
            return true;
        }
        else if(visit[node] == 1) {
            return false;
        } 

        visit[node] = path[node] = 1;

        for(int ver : adjList[node]) {
            if(this.dfs(ver, visit, path, result, adjList)) {
                return true;
            }
        }

        result[visit[visit.length - 1]++] = node;
        path[node] = 0;

        return false;
    }
}





// Approach: 2 (BFS)
// Time: O(n + e)
// Space: O(n + e)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0, node;

        for(int idx = 0; idx < numCourses; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] pair : prerequisites) {
            adjList[pair[1]].add(pair[0]);
            indegree[pair[0]] += 1;
        }

        for(int idx = 0; idx < numCourses; idx++) {
            if(indegree[idx] == 0) {
                queue.offer(idx);
            }
        }

        while(!queue.isEmpty()) {
            node = queue.poll();
            result[index++] = node;

            for(int ver : adjList[node]) {
                indegree[ver] -= 1;
                if(indegree[ver] == 0) {
                    queue.offer(ver);
                }
            }
            
        }

        return index == numCourses ? result : new int[] {};
    }
}
