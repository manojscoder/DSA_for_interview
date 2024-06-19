// Problem link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
// Time: O(n * log D), where n is the length of the given array and D is (max_val - min_val + 1) in given array
// Space: O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE, right = 0, mid, cnt, bloomCnt = 0, result = -1;

        for(int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while(left <= right) {
            mid = (left + right) / 2;
            bloomCnt = cnt = 0;

            for(int day : bloomDay) {
                if(day > mid) {
                    bloomCnt += cnt / k;
                    cnt = 0;
                }
                else {
                    cnt++;
                }
            }
            
            bloomCnt += cnt / k;

            if(bloomCnt < m) {
                left = mid + 1;
            }
            else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}
