# Problem link: https://leetcode.com/problems/parsing-a-boolean-expression/description
# Time: O(n)
# Space: O(n)
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        store = {'f' : False, 't' : True, False: 'f', True : 't'}
        stack, opr = [], []

        for char in expression:
            if char == ')':
                if opr[-1] == '!':
                    top = store[stack.pop()]
                    stack.pop()
                    opr.pop()
                    stack.append(store[not top])
                elif opr[-1] == '|':
                    top = store[stack.pop()]
                    opr.pop()

                    while stack and stack[-1] != '(':
                        top = top or (store[stack[-1]])
                        stack.pop()
                    
                    stack.pop()
                    stack.append(store[top])
                else:
                    top = store[stack.pop()]
                    opr.pop()

                    while stack[-1] != '(':
                        top = top and (store[stack[-1]])
                        stack.pop()
                    
                    stack.pop()
                    stack.append(store[top])
            else:
                if char == '&' or char == '|' or char == '!':
                    opr.append(char)
                elif char != ',':
                    stack.append(char)
                    
        return store[stack.pop()]
