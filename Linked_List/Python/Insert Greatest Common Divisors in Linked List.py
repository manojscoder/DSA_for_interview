# Problem link: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description
# Time: O(n)
# Space: O(1)
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        temp = head

        while temp.next:
            temp.next = ListNode(self.gcd(temp.val, temp.next.val), temp.next)
            temp = temp.next.next
        
        return head
    
    def gcd(self, a, b):
        if not b:
            return a
        return self.gcd(b, a % b)
