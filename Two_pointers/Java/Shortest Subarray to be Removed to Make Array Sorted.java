// Problem link: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int size = arr.length;
        int result, left = 0, right = size - 1;

        while(right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        result = right;

        while(left < right) {
            while(right < size && arr[right] < arr[left]) {
                right++;
            }

            result = Math.min(result, right - left - 1);

            if(arr[left + 1] < arr[left]) {
                break;
            }

            left++;
        }

        return result;
    }
}
