// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description
class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        int remainder = 0, val;
        ListNode temp = head;

        while(temp != null){
            val = temp.val * 2 + remainder;
            temp.val = val % 10;
            remainder = (int)val / 10;

            if(temp.next == null){
                if(remainder == 1)
                    temp.next = new ListNode(1);
                return reverse(head);
            } 
            temp = temp.next;
        }
        return null;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, nxt = null;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
