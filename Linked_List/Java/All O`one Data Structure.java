// Problem link: https://leetcode.com/problems/all-oone-data-structure/description 
// Time: O(1)
// Space: O(n)
class Node {
    int count;
    Node prev, next;
    HashSet<String> keys;

    public Node(int count) {
        this.count = count;
        this.prev = this.next = null;
        this.keys = new HashSet<>();
    }
}

class linkedList {
    Node head;
    Node tail;

    public linkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node, Node nextNode) {
        nextNode.next = node.next;
        nextNode.prev = node;
        node.next.prev = nextNode;
        node.next = nextNode;
    }

    public void removeWord(Node node, String key) {
        node.keys.remove(key);

        if(node.keys.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

class AllOne {
    linkedList dll;
    HashMap<String, Node> keysMap;

    public AllOne() {
        dll = new linkedList();
        keysMap = new HashMap<>();
    }

    public void inc(String key) {
        Node currNode = dll.head;

        if(keysMap.containsKey(key)) {
            currNode = keysMap.get(key);
        }

        int count = currNode.count + 1;
        Node nextNode = currNode.next;

        if(count != nextNode.count) {
            nextNode = new Node(count);
            dll.addNode(currNode, nextNode);
        }

        if(keysMap.containsKey(key)) {
            dll.removeWord(currNode, key);
        }

        keysMap.put(key, nextNode);
        nextNode.keys.add(key);
    }

    public void dec(String key) {
        Node currNode = keysMap.get(key);
        int count = currNode.count - 1;

        if(count == 0) {
            keysMap.remove(key);
        } 
        else {
            Node prevNode = currNode.prev;
            Node nextNode = prevNode;

            if(prevNode.count != count) {
                nextNode = new Node(count);
                dll.addNode(prevNode, nextNode);
            }

            nextNode.keys.add(key);
            keysMap.put(key, nextNode);
        }

        dll.removeWord(currNode, key);
    }

    public String getMaxKey() {
        if(!dll.tail.prev.keys.isEmpty()) {
            String word = dll.tail.prev.keys.iterator().next();
            return word;
        }
        return "";
    }

    public String getMinKey() {
        if(!dll.head.next.keys.isEmpty()) {
            String word = dll.head.next.keys.iterator().next();
            return word;
        }
        return "";
    }
}
