# Problem link: https://leetcode.com/problems/all-oone-data-structure/description
# Time: O(1)
# Space: O(n)
class Node:

    def __init__(self, count):
        self.count = count
        self.prev = self.next = None
        self.keys = set()

class LinkedList:

    def __init__(self):
        self.head, self.tail = Node(0), Node(0)
        self.head.next, self.tail.prev = self.tail, self.head
    
    def addNode(self, node, nextNode):
        nextNode.next, nextNode.prev = node.next, node
        node.next.prev = node.next = nextNode
    
    def removeWord(self, node, key):
        node.keys.remove(key)

        if not node.keys:
            node.next.prev, node.prev.next = node.prev, node.next


class AllOne:

    def __init__(self):
        self.DLL = LinkedList()
        self.keysMap = defaultdict(Node)        

    def inc(self, key: str) -> None:
        curr_node = self.DLL.head

        if key in self.keysMap:
            curr_node = self.keysMap[key]
        
        count = curr_node.count + 1
        next_node = curr_node.next

        if count != next_node.count:
            next_node = Node(count)
            self.DLL.addNode(curr_node, next_node)
        
        if key in self.keysMap:
            self.DLL.removeWord(curr_node, key)
        
        self.keysMap[key] = next_node
        next_node.keys.add(key)

    def dec(self, key: str) -> None:
        curr_node = self.keysMap[key]
        count = curr_node.count - 1

        if count == 0:
            del self.keysMap[key]
        else:
            prev_node = curr_node.prev
            next_node = prev_node

            if prev_node.count != count:
                next_node = Node(count)
                self.DLL.addNode(prev_node, next_node)
            
            next_node.keys.add(key)
            self.keysMap[key] = next_node
        
        self.DLL.removeWord(curr_node, key)

    def getMaxKey(self) -> str:
        keys = self.DLL.tail.prev.keys

        if keys:
            word = keys.pop()
            keys.add(word)
            return word
        
        return ''
        

    def getMinKey(self) -> str:
        keys = self.DLL.head.next.keys

        if keys:
            word = keys.pop()
            keys.add(word)
            return word
        
        return ''
        


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()
