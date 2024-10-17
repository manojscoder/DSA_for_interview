// Problem link: https://leetcode.com/problems/maximum-swap/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int maximumSwap(int num) {
        List<Integer> store = new ArrayList<>();
        int temp = num, result = 0, idx;

        while(temp > 0) {
            store.add(0, temp % 10);
            temp /= 10;
        }

        List<Integer> sortedList = new ArrayList<>(store);
        sortedList.sort(Collections.reverseOrder());

        for(int i = 0; i < store.size(); i++) {
            if(sortedList.get(i) != store.get(i)) {
                idx = store.size() - 1;

                while(store.get(idx) != sortedList.get(i)) {
                    idx--;
                }
                
                temp = store.get(i);
                store.set(i, store.get(idx));
                store.set(idx, temp);
                break;
            }
        }


        for(int n : store) {
            result = result * 10 + n;
        }

        return result;
    }
}
