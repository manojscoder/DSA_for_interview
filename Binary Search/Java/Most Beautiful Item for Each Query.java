// Problem link: https://leetcode.com/problems/most-beautiful-item-for-each-query/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int size = items.length, best, left, right, maxBeauty = items[0][1], query, mid;
        int[] result = new int[queries.length], store = new int[size];

        for(int index = 0; index < size; index++) {
            maxBeauty = Math.max(maxBeauty, items[index][1]);
            store[index] = maxBeauty;
        }

        for(int index = 0; index < queries.length; index++) {
            query = queries[index];
            left = 0;
            right = size - 1;
            best = 0;

            while(left <= right) {
                mid = (left + right) / 2;

                if(items[mid][0] <= query) {
                    best = store[mid];
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            result[index] = best;
        }

        return result;
    }
}
