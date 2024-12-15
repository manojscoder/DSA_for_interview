// Problem link: https://leetcode.com/problems/maximum-average-pass-ratio/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> store = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double avg, inc, result = 0, pop[], pass, total;

        for(int[] cls : classes) {
            pass = cls[0];
            total = cls[1];
            avg = pass / total;
            inc = (pass + 1) / (total + 1) - avg;
            store.offer(new double[] {inc, pass, total});
        }

        for(int student = 0; student < extraStudents; student++) {
            pop = store.poll();
            avg = (pop[1] + 1) / (pop[2] + 1);
            inc = (pop[1] + 2) / (pop[2] + 2) - avg;
            store.offer(new double[] {inc, pop[1] + 1, pop[2] + 1});
        }

        while(!store.isEmpty()) {
            pop = store.poll();
            result += pop[1] / pop[2];
        }

        return result / classes.length;
    }
}
