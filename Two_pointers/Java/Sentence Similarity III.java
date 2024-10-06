// Problem link: https://leetcode.com/problems/sentence-similarity-iii/description
// Time: O(n + m)
// Space: O(n + m)
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] storeOne = sentence1.split(" ");
        String[] storeTwo = sentence2.split(" ");

        if(storeOne.length > storeTwo.length) {
            String[] temp = storeOne;
            storeOne = storeTwo;
            storeTwo = temp;
        }

        int left = 0, rightOne = storeOne.length - 1, rightTwo = storeTwo.length - 1;

        while(left < storeOne.length && storeOne[left].equals(storeTwo[left])) {
            left++;
        }

        while(rightOne >= left && storeOne[rightOne].equals(storeTwo[rightTwo])) {
            rightOne--;
            rightTwo--;
        }

        return left > rightOne;
    }
}
