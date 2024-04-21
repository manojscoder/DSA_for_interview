// Time: O(n)
// Space: O(n)
// Problem link: https://leetcode.com/problems/valid-parentheses/description/
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty()){
            min.push(val);
        }
        else if(min.peek() >= val){
            min.push(val);
        }
    }
    
    public void pop() {
        int n = stack.pop();
        if(n == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
