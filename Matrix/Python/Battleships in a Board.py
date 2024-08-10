# Problem link: 
# Time: O(n * m)
# Space: O(1)
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        rows, cols, result = len(board), len(board[0]), 0

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 'X':
                    if (row > 0 and board[row - 1][col] == 'X') or (col > 0 and board[row][col - 1] == 'X'):
                        continue
                    result += 1
        
        return result
