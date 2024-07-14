# Problem link: https://leetcode.com/problems/number-of-atoms/description
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def countOfAtoms(self, formula: str) -> str:
        stack, result, idx = [defaultdict(int)], [], 0

        while idx < len(formula):
            if formula[idx] == '(':
                stack.append(defaultdict(int))

            elif formula[idx] == ')':
                count = idx + 1

                while count < len(formula) and formula[count].isdigit():
                    count += 1
                
                num = 1 if count == idx + 1 else int(formula[idx + 1 : count])
                idx = count - 1

                for key in stack[-1]:
                    stack[-1][key] *= num

                for key, val in stack[-1].items():
                    stack[-2][key] += val
                stack.pop()

            else:
                element = formula[idx]

                if idx + 1 < len(formula) and formula[idx + 1].islower():
                    element = formula[idx : idx + 2]
                    idx += 1
                
                count = idx + 1

                while count < len(formula) and formula[count].isdigit():
                    count += 1

                stack[-1][element] += 1 if count == idx + 1 else int(formula[idx + 1 : count])
                idx = count - 1

            idx += 1

        for ele in sorted([key for key in stack[-1]]):
            result.append(ele + ("" if stack[-1][ele] == 1 else str(stack[-1][ele])))

        return "".join(result)
