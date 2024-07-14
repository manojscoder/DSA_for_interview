// Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(-1, head);
        ListNode left = head, right = head;

        for(int idx = 0; idx < n; idx++) {
            right = right.next;
        }

        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return head.next;
    }
}
