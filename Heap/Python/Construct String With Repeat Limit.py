# Problem link: https://leetcode.com/problems/construct-string-with-repeat-limit/description/
# Time: O(n * log k)
# Space: O(n)
class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        store, result = [(-ord(char), count) for char, count in Counter(s).items()], []
        heapify(store)

        while store:

            char, count = heappop(store)
            char = chr(-char)
            result.append(char * min(count, repeatLimit))

            if repeatLimit < count and store:
                nextChar, nextCount = heappop(store)
                result.append(chr(-nextChar))
                if nextCount - 1:   heappush(store, (nextChar, nextCount - 1))
                heappush(store, (-ord(char), count - repeatLimit))
        
        return "".join(result)
