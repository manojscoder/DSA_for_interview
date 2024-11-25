# Problem link: https://leetcode.com/problems/sliding-puzzle/description
# Time: O((m * n)! * (m * n))
# Space: O((m * n)!)
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        edges = {0 : [1, 3], 1 : [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}
        store = "".join([str(num) for row in board for num in row])
        queue, visited = deque([[store, store.index("0"), 0]]), set(store)
    
        while queue:
            
            store, index, moves = queue.popleft()

            if store == "123450":
                return moves

            for edge in edges[index]:
                copy = store
                copy = copy[:index] + copy[edge] + copy[index + 1:]
                copy = copy[:edge] + '0' + copy[edge + 1:]
                if copy not in visited:
                    queue.append([copy, edge, moves + 1])
                    visited.add(copy)

        return -1
