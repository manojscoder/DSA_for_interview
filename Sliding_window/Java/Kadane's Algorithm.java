// Problem link: https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
// Time: O(n)
// Space: O(1)
class Solution{
    long maxSubarraySum(int arr[], int n){
        long maxSum = arr[0], currSum = 0;
        
        for(int i : arr){
            if(currSum < 0){
                currSum = 0;
            }
            currSum += i;
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
        
    }
    
}
