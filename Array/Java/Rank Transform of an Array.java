// Problem link: https://leetcode.com/problems/rank-transform-of-an-array/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int[] result = new int[arr.length];
        int rank = 1;

        for(int num : arr) {
            set.add(num);
        }

        for(int num : set) {
            mapping.put(num, rank++);
        }

        for(int idx = 0; idx < arr.length; idx++) {
            result[idx] = mapping.get(arr[idx]);
        }

        return result;
    }
}
