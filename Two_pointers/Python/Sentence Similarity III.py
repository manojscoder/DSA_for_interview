# Problem link: https://leetcode.com/problems/sentence-similarity-iii/description
# Time: O(n + m)
# Space: O(n)
class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        storeOne= sentence1.split()
        storeTwo = sentence2.split()

        if len(storeOne) > len(storeTwo):
            storeOne, storeTwo = storeTwo, storeOne

        left, rightOne, rightTwo = 0, len(storeOne) - 1, len(storeTwo) - 1

        while left < len(storeOne) and storeOne[left] == storeTwo[left]:
            left += 1

        while rightOne >= left and storeOne[rightOne] == storeTwo[rightTwo]:
            rightOne, rightTwo = rightOne - 1, rightTwo - 1
        
        return left > rightOne
