// Problem link: https://leetcode.com/problems/simplify-path/description
// Time: O(n)
// Space: O(n)
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(String node : path.split("/")) {
            if(!node.equals("")) {
                if(node.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                else if(!node.equals(".")) {
                    stack.push(node);
                }
            }
        }

        while(!stack.isEmpty()) {
            result.insert(0, '/' + stack.pop());
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
