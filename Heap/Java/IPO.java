// Problem link: https://leetcode.com/problems/ipo/description/
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;

        int[][] store = new int[capital.length][2];
        for(int i = 0; i < capital.length; i++){
            store[i][0] = capital[i];
            store[i][1] = profits[i];
        }

        Arrays.sort(store, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < k; i++){
            while(idx < store.length && store[idx][0] <= w){
                maxHeap.offer(store[idx][1]);
                idx++;
            }

            if(maxHeap.isEmpty()){
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
}
