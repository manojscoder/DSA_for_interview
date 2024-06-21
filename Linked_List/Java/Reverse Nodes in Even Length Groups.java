// Problem link: https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tempHead = head;
        int num = 0;

        while (tempHead != null) {
            ListNode tempTail = tempHead;
            num++;
            int lastGrp = 1;

            // reach the even length group tail
            for (int i = 0; i < num + 1; i++) {
                if (tempTail != null) {
                    tempTail = tempTail.next;
                    lastGrp++;
                }
            }

            // check whether it is end
            if (tempTail == null) {
                // if last grp have even length reverse it
                if (lastGrp % 2 == 0) {
                    tempHead.next = reverse(null, tempHead.next);
                }
                return head;
            }

            // reverse the even length group
            ListNode tempNext = tempTail.next;
            ListNode track = tempHead.next;
            tempHead.next = reverse(tempNext, track);
            tempHead = tempNext;

            num++;
            lastGrp = 0;

            // skip odd length group
            for (int i = 0; i < num; i++) {
                if (tempHead != null) {
                    tempHead = tempHead.next;
                    lastGrp++;
                }
            }

            // check whether it is end
            if (tempHead == null) {
                // if last grp have even length reverse it
                if (lastGrp % 2 == 0) {
                    track.next = reverse(null, track.next);
                }
                return head;
            }
        }

        return head;
    }

    private ListNode reverse(ListNode stop, ListNode node) {
        ListNode prev = stop;
        ListNode curr = node;

        while (curr != stop) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
