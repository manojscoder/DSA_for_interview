// Problem link: https://leetcode.com/problems/maximum-subsequence-score/description/
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> store = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long res = Integer.MIN_VALUE;
        long total = 0;

        for (int i = 0; i < nums1.length; i++) {
            store.add(new int[]{nums2[i], nums1[i]});
        }

        store.sort((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : store) {
            minHeap.offer(pair[1]);
            total += pair[1];

            if (minHeap.size() == k) {
                res = Math.max(res, pair[0] * total);
                total -= minHeap.poll();
            }
        }

        return res;
    }
}
