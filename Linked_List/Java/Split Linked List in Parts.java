// Problem link: https://leetcode.com/problems/split-linked-list-in-parts/description
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        ListNode temp = head;

        while(temp != null) {
            temp = temp.next;
            len++;
        }

        int extra = (len > k) ? len % k : 0, size = len / k, idx = 0;
        temp = head;

        while(temp != null) {
            int count = size;
            result[idx++] = temp;

            while(count > 1) {
                temp = temp.next;
                count--;
            }

            if(extra > 0) {
                temp = temp.next;
                extra--;
            }
            
            ListNode node = temp.next;
            temp.next = null;
            temp = node;
        }

        return result;
    }
}
