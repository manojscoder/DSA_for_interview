// Problem link: https://leetcode.com/problems/linked-list-cycle/description/
// Time: O(n)
// Space: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }
}
