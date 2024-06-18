// Problem link: https://leetcode.com/problems/reduce-array-size-to-the-half/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        int[] store = new int[map.size()];
        int idx = 0, result = 0, size = arr.length, left = 0, right = map.size() - 1;

        for(Integer val : map.values())
            store[idx++] = val;
        
        idx = 0;
        Arrays.sort(store);

        while(left < right) {
            store[left] += store[right];
            store[right] = store[left] - store[right];
            store[left++] -= store[right--];
        }

        while(size > (int)(arr.length / 2)) {
            size -= store[idx++];
            result++;
        }

        return result;
    }
}
