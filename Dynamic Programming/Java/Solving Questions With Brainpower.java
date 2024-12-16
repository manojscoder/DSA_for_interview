// Problem link: https://leetcode.com/problems/solving-questions-with-brainpower/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public long mostPoints(int[][] questions) {
        int size = questions.length, points, brainPower;
        long withQ, withoutQ, DP[] = new long[size];

        for(int index = size - 1; index >= 0; index--) {
            points = questions[index][0];
            brainPower = questions[index][1];
            withQ = withoutQ = 0;

            if(index + brainPower + 1 < size) {
                withQ = DP[index + brainPower + 1];
            }
            if(index + 1 < size) {
                withoutQ = DP[index + 1];
            }

            DP[index] = Math.max(points + withQ, withoutQ);
        }


        return DP[0];
    }
}
