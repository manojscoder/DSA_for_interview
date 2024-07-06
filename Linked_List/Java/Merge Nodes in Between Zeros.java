// Problem link: https://leetcode.com/problems/merge-nodes-in-between-zeros/description
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int total = 0;
        ListNode ptr_1 = head, ptr_2 = head.next;

        while(ptr_2 != null) {
            total += ptr_2.val;

            if(ptr_2.val == 0) {
                ptr_1.val = total;
                total = 0;

                if(ptr_2.next == null)
                    ptr_1.next = null;
                else
                    ptr_1 = ptr_1.next;
            }
            ptr_2 = ptr_2.next;
        }

        return head;
    }
}
