// Time: O(n)
// Space: O(n)
// Problem link: https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] store = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(store[m.getValue()] == null){
                store[m.getValue()] = new ArrayList<>();
            }
            store[m.getValue()].add(m.getKey());
        }

        int idx = 0;

        for(int i = store.length - 1; i >= 0 && k > 0; i--){
            if(store[i] != null){
                for(int j = 0; j < store[i].size(); j++){
                    if(k == 0){
                        break;
                    }
                    result[idx++] = store[i].get(j);
                    k--;
                }
            }
        }
        return result;
    }
}
