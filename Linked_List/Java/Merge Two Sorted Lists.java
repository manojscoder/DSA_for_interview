// Problem link: https://leetcode.com/problems/merge-two-sorted-lists/description/

// Approach: 1 (Iterative)
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 != null ? list1 : list2;
        return head.next;
    }
}


// Approach: 2 (Recursive)
// Time: O(n)
// Space: O(n)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
        if(list1.val < list2.val) {
            list1.next = this.mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = this.mergeTwoLists(list1, list2.next);
        return list2;
    }
}
