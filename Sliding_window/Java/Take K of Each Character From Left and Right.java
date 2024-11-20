// Problem link: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int takeCharacters(String s, int k) {
        int size = s.length();
        int right = size - 1, result, store[] = new int[3];
        char[] str = s.toCharArray();

        while(!this.valid(store, k)) {
            if(right == -1) {
                return -1;
            }

            store[str[right] - 'a']++;
            right--;
        }

        result = size - right - 1;
        right++;

        for(int left = 0; left < size; left++) {
            store[str[left] - 'a']++;

            while(right < size && this.valid(store, k)) {
                store[str[right] - 'a']--;
                right++;
            }

            if(!this.valid(store, k)) {
                right--;
                store[str[right] - 'a']++;
            }

            result = Math.min(result, left + 1 + size - right);
        }

        return result;
    }


    private boolean valid(int[] store, int k) {
        return store[0] >= k && store[1] >= k && store[2] >= k;
    }
}
