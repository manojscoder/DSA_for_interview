# Problem name: 0/1 knapSack
# Time: O(n * w)
# Space: O(w) where w is the weight of the knapSack bag
def dpKnapSack(items, knapSack_weight):
    dp = [[0] * (knapSack_weight + 1), [0] * (knapSack_weight + 1)]
    
    for i in range(1, len(items) + 1):
        for j in range(1, knapSack_weight + 1):
            if(items[i - 1][1] > j):
                dp[1][j] = dp[0][j]
            else:
                dp[1][j] = max(dp[0][j], items[i - 1][2] + dp[0][j - items[i - 1][1]])
        for j in range(knapSack_weight + 1):
            dp[0][j] = dp[1][j]
    return dp[1][knapSack_weight]
    

items = [["radio", 4, 3000], ["laptop", 3, 2000], ["guitar", 1, 1500], ["iphone", 1, 2000]]
knapSack_weight = 4
print("Maximum profit is", dpKnapSack(items, knapSack_weight))
