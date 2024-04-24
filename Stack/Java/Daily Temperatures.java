// Time: O(n)
// Space: O(n)
// Problem link: https://leetcode.com/problems/daily-temperatures/description/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int curr = 0; curr < temperatures.length; curr++){
            while(!stack.isEmpty() && temperatures[curr] > temperatures[stack.peek()]){
                int prev = stack.pop();
                arr[prev] = curr - prev;
            }
            stack.push(curr);
        }
        return arr;
    }
}
