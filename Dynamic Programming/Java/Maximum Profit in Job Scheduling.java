// Problem link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
// Time: O(n * logn)
// Space: O(n)
class Solution {
    HashMap<Integer, Integer> cache;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] intervals = new int[n][3];
        this.cache = new HashMap<>();

        for(int i = 0; i < n; i++){
            intervals[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return this.dfs(0, intervals);
    }

    public int binarySerach(int[][] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid][0] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
            
        return right;
    }

    private int dfs(int i, int[][] intervals){
        if(i == intervals.length){
            return 0;
        }
        else if(this.cache.containsKey(i)){
            return this.cache.get(i);
        }
        int profit = this.dfs(i + 1, intervals);
        int nextIdx = this.binarySerach(intervals, intervals[i][1]);
        profit = Math.max(profit, intervals[i][2] + this.dfs(nextIdx, intervals));
        this.cache.put(i, profit);
        return profit;
    }
}
