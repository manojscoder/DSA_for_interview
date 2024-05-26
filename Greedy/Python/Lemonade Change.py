# Problem link: https://leetcode.com/problems/lemonade-change/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        store = {10 : 0, 5 : 0}

        for i in bills:
            if i == 5:
                store[5] += 1
            elif i == 10:
                if store[5] == 0:
                    return False
                store[5], store[10] = store[5] - 1, store[10] + 1
            else:
                if store[10] > 0 and store[5] > 0:
                    store[5], store[10] = store[5] - 1, store[10] - 1
                elif store[5] > 2:
                    store[5] -= 3
                else:
                    return False
        
        return True
