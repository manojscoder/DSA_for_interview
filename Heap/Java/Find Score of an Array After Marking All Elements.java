// Problem link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
// Time: O(n log n)
// Space: O(n)
class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> store = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        Set<Integer> marked = new HashSet<>();
        long result = 0;

        for(int index = 0; index < nums.length; index++) {
            store.offer(new int[] {nums[index], index});
        }

        while(!store.isEmpty()) {
            while(!store.isEmpty() && marked.contains(store.peek()[1])) {
                store.poll();
            }

            if(!store.isEmpty()) {
                result += store.peek()[0];
                marked.add(store.peek()[1]);
                marked.add(store.peek()[1] - 1);
                marked.add(store.poll()[1] + 1);
            }
        }

        return result;
    }
}
