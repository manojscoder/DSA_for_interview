# Problem link: https://leetcode.com/problems/n-queens/description/
# Time: O(n!)
# Space: O(n ^ 2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result, board, colSet, negSet, posSet = [], [['.'] * n for _ in range(n)], set(), set(), set()

        def backTrack(r):
            if r == n:
                result.append(["".join(i) for i in board])
                return

            for c in range(n):
                if c not in colSet and r - c not in negSet and c + r not in posSet:
                    board[r][c] = 'Q'
                    negSet.add(r - c)
                    posSet.add(r + c)
                    colSet.add(c)

                    backTrack(r + 1)

                    board[r][c] = '.'
                    negSet.remove(r - c)
                    posSet.remove(r + c)
                    colSet.remove(c)
        
        backTrack(0)

        return result
