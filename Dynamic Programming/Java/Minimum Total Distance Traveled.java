// Problem link: https://leetcode.com/problems/minimum-total-distance-traveled/description

// Approach: DP (memo)
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

// Approach: DP Tabulation
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

        int robotCount = robot.size(), factoryCount = factories.size();
        long include, exclude;
        long[][] DP = new long[robotCount + 1][factoryCount + 1];

        for(int row = 0; row < robotCount; row++) {
            DP[row][factoryCount] = (long)1e12;
        }

        for(int row = robotCount - 1; row >= 0; row--) {
            for(int col = factoryCount - 1; col >= 0; col--) {
                include = Math.abs(robot.get(row) - factories.get(col)) + DP[row + 1][col + 1];
                exclude = DP[row][col + 1];

                DP[row][col] = Math.min(include, exclude);
            }
        }

        return DP[0][0];
    }
}

// Approach: DP (Space optimized)
// Time: O(n ^ 2 * m)
// Space: O(m)
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

        int robotCount = robot.size(), factoryCount = factories.size();
        long include, exclude;
        long[] curr = new long[factoryCount + 1], prev = new long[factoryCount + 1];

        for(int row = robotCount - 1; row >= 0; row--) {
            curr[factoryCount] = (long)1e12;
            for(int col = factoryCount - 1; col >= 0; col--) {
                include = Math.abs(robot.get(row) - factories.get(col)) + prev[col + 1];
                exclude = curr[col + 1];

                curr[col] = Math.min(include, exclude);
            }

            for(int col = 0; col < factoryCount; col++) {
                prev[col] = curr[col];
                curr[col] = 0;
            }

            prev[factoryCount] = (long)1e12;
        }

        return prev[0];
    }
}
