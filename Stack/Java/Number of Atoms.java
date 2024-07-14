// Problem link: https://leetcode.com/problems/number-of-atoms/description
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int idx = 0, count;
        StringBuilder result = new StringBuilder();
        char[] str = formula.toCharArray();

        stack.push(new HashMap<>());

        while(idx < str.length) {
            if(str[idx] == '(') {
                stack.push(new HashMap<>());
            }
            else if(str[idx] == ')') {
                Map<String, Integer> popMap = stack.pop();

                count = 0;

                while(idx + 1 < str.length && str[idx + 1] >= '0' && str[idx + 1] <= '9') {
                    count = (count * 10) + (str[idx + 1] - '0');
                    idx += 1;
                }

                count = count == 0 ? 1 : count;

    
                for(String key : popMap.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + popMap.get(key) * count);
                }
            }
            else {
                StringBuilder element = new StringBuilder();
                element.append(str[idx]);

                if(idx + 1 < str.length && str[idx + 1] >= 'a' && str[idx + 1] <= 'z') {
                    element.append(str[idx + 1]);
                    idx += 1;
                }

                String ele = element.toString();
                count = 0;

                while(idx + 1 < str.length && str[idx + 1] >= '0' && str[idx + 1] <= '9') {
                    count = (count * 10) + (str[idx + 1] - '0');
                    idx += 1;
                }
                
                count = count == 0 ? 1 : count;
                stack.peek().put(ele, stack.peek().getOrDefault(ele, 0) + count);
            }
            idx += 1;
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.pop());

        for(String key : sortedMap.keySet()) {
            if(sortedMap.get(key) > 1) {
                result.append(key + String.valueOf(sortedMap.get(key)));
            }
            else {
                result.append(key);
            }
        }

        return result.toString();
    }
}
