// Problem link: https://leetcode.com/problems/longest-mountain-in-array/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int longestMountain(int[] arr) {
        int size = arr.length, result = 0, left, right;

        if(size < 3) {
            return 0;
        }

        for(int index = 1; index < size - 1; index++) {
            if(arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
                left = right = index;

                while(left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                while(right < size - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                result = result < right - left + 1 ? right - left + 1 : result;
            }
        }

        return result;
    }
}
