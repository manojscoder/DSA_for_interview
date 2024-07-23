// Problem link: https://leetcode.com/problems/last-stone-weight/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxStones = new PriorityQueue<>();
        int heavyOne, heavyTwo;

        for(int s : stones) {
            maxStones.offer(-s);
        }

        while(maxStones.size() > 1) {
            heavyOne = -maxStones.poll();
            heavyTwo = -maxStones.poll();

            if(heavyOne != heavyTwo) {
                maxStones.offer(-(heavyOne - heavyTwo));
            }
        }

        return maxStones.size() > 0 ? -maxStones.poll() : 0;
    }
}
