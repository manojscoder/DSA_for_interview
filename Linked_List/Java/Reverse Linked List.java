// Problem link: https://leetcode.com/problems/reverse-linked-list/description/
// Time: O(n)
// Space: O(1) for iteratively and O(n) for recursive solution(Call stack)

// Solution 1:(Iterative)
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, nxt = null;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}

// Solution 2:(Recursive)
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
