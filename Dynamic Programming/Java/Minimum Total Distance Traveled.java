// Problem link: https://leetcode.com/problems/minimum-total-distance-traveled/description
// Time: O(n ^ 2 * m)
// Space: O(n * m)
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> factories = new ArrayList<>();

        for(int[] pair : factory) {
            for(int limit = 0; limit < pair[1]; limit++) {
                factories.add(pair[0]);
            }
        }

        int rows = robot.size(), cols = factories.size();
        long[][] DP = new long[rows][cols];

        for(long[] row : DP) {
            Arrays.fill(row, -1);
        }

        return this.dfs(robot, factories, 0, 0, DP);
    }

    private long dfs(List<Integer> robot, List<Integer> factories, int rIdx, int fIdx, long[][] DP) {
        if(rIdx == robot.size()) {
            return 0;
        }
        else if(fIdx == factories.size()) {
            return (long)1e12;
        }
        else if(DP[rIdx][fIdx] != -1) {
            return DP[rIdx][fIdx];
        }

        Long include = Math.abs(robot.get(rIdx) - factories.get(fIdx)) + this.dfs(robot, factories, rIdx + 1, fIdx + 1, DP);
        Long exclude = this.dfs(robot, factories, rIdx, fIdx + 1, DP);

        DP[rIdx][fIdx] = Math.min(include, exclude);
        return DP[rIdx][fIdx];
    }
}
