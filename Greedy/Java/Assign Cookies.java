// Problem link: https://leetcode.com/problems/assign-cookies/description/
// Time: O(nlogn)
// Space: O(n) for sorting
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;

        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }

        return i;
    }
}
