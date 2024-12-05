// Problem link: https://leetcode.com/problems/move-pieces-to-obtain-a-string/description
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean canChange(String start, String target) {
        int size = start.length(), startIdx = 0, targetIdx = 0;

        while(startIdx < size || targetIdx < size) {

            while(startIdx < size && start.charAt(startIdx) == '_')
                startIdx++;
            
            while(targetIdx < size && target.charAt(targetIdx) == '_')
                targetIdx++;
            
            if(startIdx == size || targetIdx == size)
                return startIdx == size && targetIdx == size;
            
            if(start.charAt(startIdx) != target.charAt(targetIdx))
                return false;
            
            if((start.charAt(startIdx) == 'L' && startIdx < targetIdx) || (start.charAt(startIdx) == 'R' && startIdx > targetIdx))
                return false;

            startIdx++;
            targetIdx++;
        }

        return true;
    }
}
