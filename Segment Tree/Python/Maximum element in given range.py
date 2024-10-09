# Time for build: O(n)
# Time for query: O(log n)
# Space: O(4 * n)
class segmentTree:
    
    def __init__(self, arr):
        self.size = len(arr)
        self.segment = [0] * (4 * self.size)
        self.build(0, 0, self.size - 1, arr)
    
    def build(self, index, low, high, arr):
        if low == high:
            self.segment[index] = arr[low]
            return
        mid = (low + high) // 2
        self.build(2 * index + 1, low, mid, arr)
        self.build(2 * index + 2, mid + 1, high, arr)
        self.segment[index] = max(self.segment[2 * index + 1], self.segment[2 * index + 2])
    
    def query(self, index, low, high, l, r):
        if low >= l and high <= r:
            return self.segment[index]
        
        if high < l or low > r:
            return float('-inf')
        
        mid = (low + high) // 2
        left = self.query(2 * index + 1, low, mid, l, r)
        right = self.query(2 * index + 2, mid + 1, high, l, r)
        return max(left, right)

arr = [8, 2, 5, 1, 4, 5, 3, 9, 6, 10]
DS = segmentTree(arr)
print("Maximum element in range 3 and 8 is:", DS.query(0, 0, DS.size - 1, 3, 8))
print("Maximum element in range 2 and 5 is:", DS.query(0, 0, DS.size - 1, 2, 5))
print("Maximum element in range 1 and 9 is:", DS.query(0, 0, DS.size - 1, 1, 9))
