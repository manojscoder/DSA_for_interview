// problem link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
// Time: O(n log (sum(weights) - max(weights)))
// Space: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0, mid, count, total;

        for(int w : weights) {
            right += w;
            left = Math.max(left, w);
        }

        while(left <= right) {
            mid = left + (right - left) / 2;

            count = 1;
            total = 0;

            for(int w : weights) {
                total += w;

                if(total > mid) {
                    count++;
                    total = w;
                    
                    if(count > days)
                        break;
                }
            }

            if(count <= days)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
