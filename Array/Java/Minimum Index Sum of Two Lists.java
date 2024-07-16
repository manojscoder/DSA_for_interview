// Problem link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
// Time: O(m + n)
// Space: O(n)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSum = Integer.MAX_VALUE, size = 0, val, len_1 = list1.length, len_2 = list2.length;
        Map<String, Integer> store = new HashMap<>();

        for(int idx = 0; idx < len_1; idx++) {
            store.put(list1[idx], idx);
        }

        for(int idx = 0; idx < len_2; idx++) {
            val = store.getOrDefault(list2[idx], len_1 + len_2);
            if(minSum >= idx + val) {
                if(minSum > idx + val) {
                    minSum = idx + val;
                    size = 0;
                }
                size++;
            }
        }

        String[] result = new String[size];

        for(int idx = 0; idx < len_2; idx++) {
            val = store.getOrDefault(list2[idx], len_1 + len_2);
            if(minSum == idx + val) {
                result[size - 1] = list2[idx];
                size--;
            }
        }

        return result;
    }
}
