// Problem link: https://leetcode.com/problems/range-sum-query-immutable/
// Time: O(log n) for sumRange method
// Space: O(n)
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class segmentTree {
    Node tree;
    int size;

    public segmentTree(int[] nums) {
        this.size = nums.length;
        this.tree = this.buildTree(0, this.size - 1, nums);
    }

    public Node buildTree(int low, int high, int[] nums) {
        if(low == high) {
            return new Node(nums[low]);
        }

        int mid = (low + high) / 2;

        Node node = new Node(-1);
        node.left = this.buildTree(low, mid, nums);
        node.right = this.buildTree(mid + 1, high, nums);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public int queryTree(Node node, int low, int high, int left, int right) {
        if(low >= left && high <= right) {
            return node.data;
        }
        else if(high < left || low > right) {
            return 0;
        }

        int mid = (low + high) / 2;
        int leftSum = this.queryTree(node.left, low, mid, left, right);
        int rightSum = this.queryTree(node.right, mid + 1, high, left, right);

        return leftSum + rightSum;
    }
}


class NumArray {
    segmentTree DS;

    public NumArray(int[] nums) {
        this.DS = new segmentTree(nums);
    }
    
    public int sumRange(int left, int right) {
        return this.DS.queryTree(this.DS.tree, 0, this.DS.size - 1, left, right);
    }
}
