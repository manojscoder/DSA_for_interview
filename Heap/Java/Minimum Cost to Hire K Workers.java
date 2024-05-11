// Problem link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<double[]> ratio = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double totalQuality = 0;
        double res = Double.POSITIVE_INFINITY;

        for (int i = 0; i < quality.length; i++) {
            ratio.add(new double[]{(double) wage[i] / quality[i], (double) quality[i]});
        }

        ratio.sort(Comparator.comparingDouble(a -> a[0]));

        for (double[] pair : ratio) {
            maxHeap.offer((int) pair[1]);
            totalQuality += pair[1];

            if (maxHeap.size() == k) {
                res = Math.min(res, pair[0] * totalQuality);
                totalQuality -= maxHeap.poll();
            }
        }

        return res;
    }
}
