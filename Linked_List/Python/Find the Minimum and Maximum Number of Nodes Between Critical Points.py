# Time: O(n)
# Space: O(1)
# Problem link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        prev, temp, count, f_point, p_point, min_maxima = head.val, head.next, 1, -1, -1, inf

        while temp.next:
            if (temp.val > prev and temp.val > temp.next.val) or (temp.val < prev and temp.val < temp.next.val):
                f_point = count if f_point == -1 else f_point
                min_maxima = min(min_maxima, count - p_point) if p_point != -1 else min_maxima
                p_point = count
            prev, count, temp = temp.val, count + 1, temp.next
        
        return [-1, -1] if p_point == f_point else [min_maxima, p_point - f_point]
