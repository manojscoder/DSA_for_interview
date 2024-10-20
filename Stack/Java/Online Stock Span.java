// Problem link: https://leetcode.com/problems/online-stock-span/description/
// Time: O(n)
// Space: O(n)
class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int result = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            result += stack.pop()[1];
        }

        stack.push(new int[] {price, result});

        return result;
    }
}
