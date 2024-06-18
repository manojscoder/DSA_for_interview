// Problem link: https://leetcode.com/problems/the-latest-time-to-catch-a-bus/description/
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int idx = 0, cap = 0, start = 0;

        for(int i = 0; i < buses.length; i++) {
            cap = capacity;
            start = buses[i];

            while(idx < passengers.length && start >= passengers[idx] && cap > 0) {
                cap--;
                idx++;
            }
        }

        int result = cap > 0 ? start : passengers[idx - 1];

        while(idx - 1 >= 0 && result == passengers[idx - 1]) {
            result--;
            idx--;
        }

        return result;
    }
}
