// Problem link: https://leetcode.com/problems/design-a-stack-with-increment-operation/description
// Time: O(1)
// Space: O(n)
class CustomStack {

    int[] stack, inc;
    int top;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int x) {
        if(this.stack.length - 1 > this.top) {
            this.stack[++this.top] = x;
        }
    }
    
    public int pop() {
        if(this.top >= 0) {
            int value = this.stack[this.top] + this.inc[this.top];

            if(this.top > 0) {
                this.inc[this.top - 1] += this.inc[this.top];
            }

            this.inc[this.top--] = 0;
            return value;
        }
        return -1;
        
    }
    
    public void increment(int k, int val) {
        if(this.top >= 0) {
            this.inc[Math.min(this.top, k - 1)] += val;
        }
        
    }
}
