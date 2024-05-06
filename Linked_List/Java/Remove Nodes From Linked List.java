// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/remove-nodes-from-linked-list/description/
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.val < temp.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return reverse(head);
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
