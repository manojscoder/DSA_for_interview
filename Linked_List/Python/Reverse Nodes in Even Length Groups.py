# Problem link: https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        
        temp_head, num = head, 0

        while temp_head:
            temp_tail, num, last_grp = temp_head, num + 1, 1

            # reach the even length group tail
            for i in range(num + 1):
                if temp_tail:
                    temp_tail = temp_tail.next
                    last_grp += 1
            
            # check whether it is end
            if not temp_tail:
                # if last grp have even length reverse it
                if last_grp % 2 == 0:
                    temp_head.next = self.reverse(None, temp_head.next)

                return head
            
            # reverse the even length group
            temp_next, track = temp_tail.next, temp_head.next
            temp_head.next = self.reverse(temp_next, track)
            temp_head = temp_next
            
            num, last_grp = num + 1, 0

            # skip odd length group
            for i in range(num):
                if temp_head:
                    temp_head = temp_head.next
                    last_grp += 1
            
            # check whether it is end
            if not temp_head:
                # if last grp have even length reverse it
                if last_grp % 2 == 0:
                    track.next = self.reverse(None, track.next)

                return head
        
        return head
            

    
    def reverse(self, stop, node):
        prev, nxt, curr = stop, None, node

        while curr != stop:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev
                
