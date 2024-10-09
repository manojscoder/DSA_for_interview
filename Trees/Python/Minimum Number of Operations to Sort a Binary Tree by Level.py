# Problem link: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        queue = deque([root])
        result = 0

        while queue:
            store = []
            for _ in range(len(queue)):
                node = queue.popleft()
                store.append(node.val)

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
            
            result += self.countSwaps(store)
        
        return result
    
    def countSwaps(self, nums):
        store = {num : idx for idx, num in enumerate(sorted(nums))}
        count = idx = 0

        while idx < len(nums):
            if store[nums[idx]] == idx:
                idx += 1
            else:
                nums[store[nums[idx]]], nums[idx] = nums[idx], nums[store[nums[idx]]]
                count += 1
        
        return count
