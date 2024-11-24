// Problem link: https://leetcode.com/problems/maximum-matrix-sum/description
// Time: O(n * n)
// Space: O(n * n)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int track = Integer.MAX_VALUE, count = 0;
        long result = 0;

        for(int[] arr : matrix) {
            for(int num : arr) {
                if(num < 0) {
                    count++;
                }
                result += Math.abs(num);
                track = Math.min(track, Math.abs(num));
            }
        }

        return count % 2 == 0 ? result : result - track * 2;
    }
}
