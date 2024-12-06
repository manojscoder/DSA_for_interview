// Problem link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> store = new HashSet<>();
        int total = 0, count = 0;

        for(int num : banned) {
            store.add(num);
        }

        for(int num = 1; num <= n; num++) {
            if(!store.contains(num)) {
                if(total + num > maxSum) {
                    return count;
                }
                count++;
                total += num;
            }
        }

        return count;
    }
}
