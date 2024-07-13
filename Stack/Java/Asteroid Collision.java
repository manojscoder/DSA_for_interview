// Problem link: https://leetcode.com/problems/asteroid-collision/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < asteroids.length; idx++) {
            while(!stack.isEmpty() && asteroids[idx] < 0 && stack.peek() > 0) {
                if(asteroids[idx] + stack.peek() < 0) {
                    stack.pop();
                }
                else if(asteroids[idx] + stack.peek() > 0) {
                    asteroids[idx] = 0;
                }
                else {
                    stack.pop();
                    asteroids[idx] = 0;
                }
            }

            if(asteroids[idx] != 0)
                stack.push(asteroids[idx]);
        }

        int len = stack.size();
        int[] result = new int[len];

        for(int idx = len - 1; idx >= 0; idx--)
            result[idx] = stack.pop();
        
        return result;
    }
}
