// Problem link: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> store;
        int result = 0, size;
        TreeNode curr;

        queue.add(root);
        while(!queue.isEmpty()) {
            size = queue.size();
            store = new ArrayList<>();

            for(int idx = 0; idx < size; idx++) {
                curr = queue.poll();
                store.add(curr.val);

                if(curr.left != null) {
                    queue.add(curr.left);
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }

            result += this.countSwaps(store);
        }

        return result;
    }

    private int countSwaps(List<Integer> store) {
        int[] nums = new int[store.size()];

        for(int idx = 0; idx < store.size(); idx++) {
            nums[idx] = store.get(idx);
        }

        Collections.sort(store);
        Map<Integer, Integer> mapping = new HashMap<>();

        for(int idx = 0; idx < store.size(); idx++) {
            mapping.put(store.get(idx), idx);
        }

        int idx = 0, count = 0;

        while(idx < store.size()) {
            if(mapping.get(nums[idx]) == idx) {
                idx++;
            }
            else {
                int temp = nums[mapping.get(nums[idx])];
                nums[mapping.get(nums[idx])] = nums[idx];
                nums[idx] = temp;
                count++;
            }
        }

        return count;
    }
}
