// Time: O(n)
// Space: O(n)
// Problem link: https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int len = heights.length, result = 0, prev_index;
        for(int i = 0; i < len; i++){
            prev_index = i;
            while(!stack.isEmpty() && stack.peek().getKey() > heights[i]){
                Pair<Integer, Integer> pair = stack.pop();
                result = Math.max(result, pair.getKey() * (i - pair.getValue()));
                prev_index = pair.getValue();
            }
            stack.push(new Pair(heights[i], prev_index));
        }

        while(!stack.isEmpty()){
            Pair<Integer, Integer> pair = stack.pop();
            result = Math.max(result, pair.getKey() * (len - pair.getValue()));
        }
        return result;
    }
}
