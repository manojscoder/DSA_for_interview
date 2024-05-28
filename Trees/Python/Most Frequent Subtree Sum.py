# Problem link: https://leetcode.com/problems/most-frequent-subtree-sum/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
       
        def dfs(root):
            if not root:
                return 0
            currSum = root.val + dfs(root.left) + dfs(root.right)
            store[currSum] += 1
            return currSum

        store = defaultdict(int)
        dfs(root)
        res = max(store.values())

        return [key for key, val in store.items() if res == val]
