// Problem link: https://leetcode.com/problems/add-two-numbers/
// Time: O(n) where n is the max length of l1 list and l2 list
// Space: O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0, value;

        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(l1 != null || l2 != null || remainder == 1) {
            value = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remainder;
            curr.next = new ListNode(value % 10);
            remainder = value / 10;
            curr = curr.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        return result.next;
    }
}
