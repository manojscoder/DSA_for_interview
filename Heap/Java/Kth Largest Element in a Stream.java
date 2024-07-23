// Problem link:https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// Time: O(n log n)
// Space: O(n)
class KthLargest {
    int num;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.num = k;
        this.queue = new PriorityQueue<>();

        for(int n : nums) {
            this.queue.offer(n);
        }

        while(this.queue.size() > this.num) {
            this.queue.poll();
        }
    }
    
    public int add(int val) {
        this.queue.offer(val);

        if(this.queue.size() > this.num) {
            this.queue.poll();
        }

        return this.queue.peek();
    }
}
