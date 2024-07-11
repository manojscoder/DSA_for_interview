// Problem link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description

// Approach: 1
// Time: O(n * m), where n is the number of alphabets in s and m in number of pairs of parentheses
// Space: O(n)
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == ')') {
                while(stack.peek() != '(')
                    queue.offer(stack.pop());

                stack.pop();

                while(!queue.isEmpty())
                    stack.push(queue.poll());
            }
            else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty())
            result.append(stack.pop());

        return result.reverse().toString();
    }
}


// Approach: 2
// Time: O(n), where n is the length of the input s
// Space: O(n)
class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, Integer> pair = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        char[] str = s.toCharArray();
        int index = 0, direction = 1;

        for(int i = 0; i < s.length(); i++) {
            if(str[i] == '(') {
                stack.push(i);
            }
            else if(str[i] == ')') {
                pair.put(i, stack.peek());
                pair.put(stack.pop(), i);
            }
        }

        while(index < s.length()) {
            if(str[index] == '(' || str[index] == ')') {
                index = pair.get(index);
                direction *= -1;
            }
            else{
                result.append(str[index]);
            }
            index += direction;
        }

        return result.toString();   
    }
}
