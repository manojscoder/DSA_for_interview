// Problem link: https://leetcode.com/problems/longest-happy-string/description
// Time: O(a + b + c)
// Space: O(1)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        StringBuilder result = new StringBuilder();
        int prev = 0, count, one[], two[];

        if(a > 0)
            queue.offer(new int[] {a, 'a'});
        if(b > 0)
            queue.offer(new int[] {b, 'b'});
        if(c > 0)
            queue.offer(new int[] {c, 'c'});
        

        while(!queue.isEmpty()) {
            one = queue.poll();
            
            if(one[1] == prev) {
                if(queue.isEmpty())
                    break;
                two = queue.poll();
                queue.offer(one);
                one = two;
            }

            count = Math.min(2, one[0]);
            prev = one[1];

            if(!queue.isEmpty() && queue.peek()[0] > one[0])
                count = 1;

            if(count == 1)
                result.append((char)one[1]);
            else
                result.append((char)one[1]).append((char)one[1]);

            if(one[0] - count > 0) {
                one[0] -= count;
                queue.offer(one);
            }
        }

        return result.toString();
    }
}
