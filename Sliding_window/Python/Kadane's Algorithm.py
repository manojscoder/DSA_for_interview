# Problem link: https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
# Time: O(n)
# Space: O(1)
class Solution:
    def maxSubArraySum(self,arr,N):
        maxSum, currSum = arr[0], 0
        
        for i in arr:
            if currSum < 0:
                currSum = 0
            currSum += i
            maxSum = max(maxSum, currSum)
        
        return maxSum
