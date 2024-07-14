// Problem link: https://leetcode.com/problems/reorder-list/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next, nxt = null;

        while(curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        fast = head;

        while(prev != null) {
            nxt = prev.next;
            prev.next = fast.next;
            fast.next = prev;
            fast = prev.next;
            prev = nxt;
        }

        fast.next = prev;
    }
}
