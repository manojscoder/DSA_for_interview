# Problem link: https://leetcode.com/problems/longest-happy-string/description
# Time: O(a + b + c)
# Space: O(1)
class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        maxHeap, result, prev = [[-x, y] for x, y in zip((a, b, c), ('a', 'b', 'c')) if x], [], ''
        heapify(maxHeap)

        while maxHeap:
            one = heappop(maxHeap)
            if prev == one[1]:
                if not maxHeap:
                    break
                two = heappop(maxHeap)
                heappush(maxHeap, one)
                one = two
            
            count, prev = min(2, -one[0]), one[1]
            if maxHeap and -maxHeap[0][0] > -one[0]:
                count = 1
                
            result.append(one[1] * count)
            if -one[0] - count > 0:
                one[0] += count
                heappush(maxHeap, one)

        return ''.join(result)
