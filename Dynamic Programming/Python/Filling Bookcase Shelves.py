# Problem link: https://leetcode.com/problems/filling-bookcase-shelves/description

# Approach: 1 (Bottom - up solution)
# Time: O(n * w)
# Space: O(n)
class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        dp = [0] * (len(books) + 1)

        for index in range(len(books) - 1, -1, -1):
            maxHeight, dp[index] = 0, float('inf')
            currWidth = shelfWidth

            for idx in range(index, len(books)):
                width, height = books[idx]
                if currWidth < width:
                    break
                
                currWidth -= width
                maxHeight = max(height, maxHeight)
                dp[index] = min(dp[index], dp[idx + 1] + maxHeight)
        
        return dp[0]

# Approach: 2 (Top - up solution)
# Time: O(n * w)
# Space: O(n)
class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        return self.dfs(0, books, shelfWidth, {})
    
    def dfs(self, index, books, shelfWidth, cache):
        if index == len(books):
            return 0
        elif index in cache:
            return cache[index]
        
        maxHeight, cache[index] = 0, float('inf')
        currWidth = shelfWidth

        for idx in range(index, len(books)):
            width, height = books[idx]
            if currWidth < width:
                break
            
            currWidth -= width
            maxHeight = max(height, maxHeight)
            cache[index] = min(cache[index], self.dfs(idx + 1, books, shelfWidth, cache) + maxHeight)

        return cache[index]
