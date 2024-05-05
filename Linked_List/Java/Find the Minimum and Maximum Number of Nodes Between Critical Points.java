// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int prev = head.val, count = 1, f_point = -1, p_point = -1, min_maxima = Integer.MAX_VALUE;

        while(temp.next != null) {
            if((temp.val > prev && temp.val > temp.next.val) || (temp.val < prev && temp.val < temp.next.val)) {
                f_point = f_point == -1 ? count : f_point;
                min_maxima = (p_point != -1) ? Math.min(min_maxima, count - p_point) : min_maxima;
                p_point = count;
            }
            prev = temp.val;
            count++;
            temp = temp.next;
        }

        if(p_point == f_point){
            return new int[]{-1, -1};
        } 
        return new int[]{min_maxima, p_point - f_point};
    }
}
