# Problem link: https://leetcode.com/problems/split-linked-list-in-parts/description
# Time: O(n)
# Space: O(1)
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        length, temp, result = 0, head, [None] * k

        while temp:
            temp = temp.next
            length += 1
        
        extra, size, temp, idx = (length % k) if length > k else 0, length // k, head, 0

        while temp:
            count = size
            result[idx] = temp
            idx += 1

            while count > 1:
                temp = temp.next
                count -= 1
            
            if extra:
                temp = temp.next
                extra -= 1
            
            node = temp.next
            temp.next = None
            temp = node
        
        return result
