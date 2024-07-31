// Problem link: https://leetcode.com/problems/filling-bookcase-shelves/description

// Approach: 1 (Bottom - up solution)
// Time: O(n * w)
// Space: O(n)
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int size = books.length, currWidth, maxHeight;
        int[] dp = new int[size + 1];

        for(int index = size - 1; index >= 0; index--) {
            currWidth = shelfWidth;
            maxHeight = 0;
            dp[index] = Integer.MAX_VALUE;

            for(int idx = index; idx < books.length; idx++) {
                if(currWidth < books[idx][0]) {
                    break;
                }
                
                currWidth -= books[idx][0];
                maxHeight = Math.max(maxHeight, books[idx][1]);
                dp[index] = Math.min(dp[index], dp[idx + 1] + maxHeight);
            }
        }

        return dp[0];
    }
}


// Approach: 2 (Top - down solution)
// Time: O(n * w)
// Space: O(n)
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return this.dfs(0, books, shelfWidth, new HashMap<>());
    }

    private int dfs(int index, int[][] books, int shelfWidth, Map<Integer, Integer> cache) {
        if(index == books.length) {
            return 0;
        }
        else if(cache.containsKey(index)) {
            return cache.get(index);
        }

        int currWidth = shelfWidth, maxHeight = 0;
        cache.put(index, Integer.MAX_VALUE);

        for(int idx = index; idx < books.length; idx++) {
            if(currWidth < books[idx][0]) {
                break;
            }

            currWidth -= books[idx][0];
            maxHeight = Math.max(maxHeight, books[idx][1]);

            cache.put(index, Math.min(cache.get(index), this.dfs(idx + 1, books, shelfWidth, cache) + maxHeight));
        }

        return cache.get(index);
    }
}
