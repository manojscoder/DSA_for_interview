# Problem link: https://leetcode.com/problems/maximum-swap/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def maximumSwap(self, num: int) -> int:
        store, temp, result = [], num, 0

        while temp:
            store.insert(0, temp % 10)
            temp //= 10
        
        temp = sorted(store, reverse = True)

        for i in range(len(temp)):
            if temp[i] != store[i]:
                idx = len(store) - 1

                while store[idx] != temp[i]:
                    idx -= 1
                
                store[i], store[idx] = store[idx], store[i]
                break

        for n in store:
            result = result * 10 + n
        
        return result    
