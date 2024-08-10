# Problem link: 
# Time: O(n * m)
# Space: O(1)
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        rows, cols, result = len(board), len(board[0]), 0
       

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 'X':
                    self.dfs(row, col, board, rows, cols)
                    result += 1
        
        return result

    def dfs(self, row, col, board, rows, cols):
        if row < 0 or col < 0 or row == rows or col == cols:
            return
        
        board[row][col] = '.'

        if row + 1 < rows and board[row + 1][col] == 'X':
            self.dfs(row + 1, col, board, rows, cols)
        elif col + 1 < cols and board[row][col + 1] == 'X':
            self.dfs(row, col + 1, board, rows, cols)
