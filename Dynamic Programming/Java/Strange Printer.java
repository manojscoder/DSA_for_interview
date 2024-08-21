// Problem link: https://leetcode.com/problems/strange-printer/description
// Time: O(n ^ 3)
// Space: O(n ^ 2)
class Solution {
    public int strangePrinter(String s) {
        int size = s.length();
        char[] str = s.toCharArray();
        int[][] cache = new int[size][size];

        return this.DP(cache, 0, size - 1, str);
    }

    private int DP(int[][] cache, int start, int end, char[] str) {
        if(start == end) {
            return 1;
        }
        else if(cache[start][end] != 0) {
            return cache[start][end];
        }
        
        int moves = Integer.MAX_VALUE;

        for(int idx = start; idx < end; idx++) {
            moves = Math.min(moves, this.DP(cache, start, idx, str) + this.DP(cache, idx + 1, end, str));
            
        }
        
        cache[start][end] = str[start] == str[end] ? moves - 1 : moves;
        return cache[start][end];
    }
}
