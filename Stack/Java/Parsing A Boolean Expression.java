// Problem link: https://leetcode.com/problems/parsing-a-boolean-expression/description
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> opr = new Stack<>();
        boolean top;

        for(char chr : expression.toCharArray()) {
            if(chr == ')') {
                if(opr.peek() == '!') {
                    top = stack.pop() == 't' ? true : false;
                    opr.pop();
                    stack.pop();
                    stack.push(top ? 'f' : 't');
                }
                else if(opr.peek() == '|') {
                    top = stack.pop() == 't' ? true : false;
                    opr.pop();

                    while(stack.peek() != '(') {
                        top = top || stack.peek() == 't' ? true : false;
                        stack.pop();
                    }

                    stack.pop();
                    stack.push(top ? 't' : 'f');
                }
                else {
                    top = stack.pop() == 't' ? true : false;
                    opr.pop();

                    while(stack.peek() != '(') {
                        top = top && stack.peek() == 't' ? true : false;
                        stack.pop();
                    }

                    stack.pop();
                    stack.push(top ? 't' : 'f');
                }
            }
            else {
                if(chr == '!' || chr == '|' || chr == '&') {
                    opr.push(chr);
                }
                else if(chr != ',') {
                    stack.push(chr);
                }
            }
        }

        return stack.pop() == 't' ? true : false;
    }
}
