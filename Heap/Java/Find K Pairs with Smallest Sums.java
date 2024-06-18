// Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// Time: O(n + k log n)
// Space: O(m + k)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int n : nums1) {
            minHeap.add(new int[] {n + nums2[0], 0});
        }

        while(k > 0 && minHeap.size() > 0) {
            int[] temp = minHeap.poll();

            List<Integer> res = new ArrayList<>();
            res.add(temp[0] - nums2[temp[1]]);
            res.add(nums2[temp[1]]);

            result.add(res);

            if(temp[1] + 1 < nums2.length) {
                minHeap.add(new int[] {temp[0] - nums2[temp[1]] + nums2[temp[1] + 1], temp[1] + 1});
            }

            k -= 1;
        }

        return result;
    }
}
