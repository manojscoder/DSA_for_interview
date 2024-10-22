# Problem link: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
# Time: O(n * log h)
# Space: O(n)
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        minHeap = []

        queue = deque([root])

        while queue:

            total = 0

            for _ in range(len(queue)):

                node = queue.popleft()
                total += node.val

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)

            heappush(minHeap, total)

            if len(minHeap) > k:
                heappop(minHeap)

        return minHeap[0] if len(minHeap) == k else -1
