// Problem link: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description 
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        while(temp.next != null) {
            temp.next = new ListNode(this.gcd(temp.val, temp.next.val), temp.next);
            temp = temp.next.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return this.gcd(b, a % b);
    }
}
