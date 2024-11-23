# Problem link: https://leetcode.com/problems/rotating-the-box/description/
# Time: O(m * n)
# Space: O(n * m)
class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        m, n = len(box), len(box[0])
        result = [['.'] * m for _ in range(n)]
        rw, cl = m - 1, n - 1

        for col in range(m):
            row = cl = n - 1

            while cl >= 0:
                if box[rw][cl] == '#':
                    result[row][col] = '#'
                    row -= 1
                elif box[rw][cl] == '*':
                    result[cl][col] = '*'
                    row = cl - 1
                
                cl -= 1

            rw -= 1

        return result 
