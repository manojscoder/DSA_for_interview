// Problem link: https://leetcode.com/problems/different-ways-to-add-parentheses/description
// Time: O(n * 2  ^ n)
// Space: O(2 ^ n)
class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> result = new ArrayList<>();

        for(int idx = 0; idx < exp.length(); idx++) {
            if(exp.charAt(idx) == '+' || exp.charAt(idx) == '-' || exp.charAt(idx) == '*') {
                List<Integer> left = this.diffWaysToCompute(exp.substring(0, idx));
                List<Integer> right = this.diffWaysToCompute(exp.substring(idx + 1, exp.length()));

                for(int n1 : left) {
                    for(int n2 : right) {
                        if(exp.charAt(idx) == '+') {
                            result.add(n1 + n2);
                        }
                        else if(exp.charAt(idx) == '-') {
                            result.add(n1 - n2);
                        }
                        else {
                            result.add(n1 * n2);
                        }
                    }
                }
            }
        }

        if(result.size() == 0) {
            result.add(Integer.valueOf(exp));
        }

        return result;
    }
}
