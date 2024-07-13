// Problem link: https://leetcode.com/problems/robot-collisions/description/
// Time: O(n * log n)
// Space: O(n)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int len = positions.length, pstIdx, popIdx;
        Map<Integer, Integer> idxMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        char[] dir = directions.toCharArray();
        List<Integer> result = new ArrayList<>();

        for(int idx = 0; idx < len; idx++)
            idxMap.put(positions[idx], idx);
        
        Arrays.sort(positions);

        for(int idx = 0; idx < len; idx++) {
            pstIdx = idxMap.get(positions[idx]);

            if(dir[pstIdx] == 'R') {
                stack.push(pstIdx);
            }
            else {
                while(!stack.isEmpty() && healths[pstIdx] != 0) {
                    popIdx = stack.pop();
                    if(healths[pstIdx] > healths[popIdx]) {
                        healths[popIdx] = 0;
                        healths[pstIdx] -= 1;
                    }
                    else if(healths[pstIdx] < healths[popIdx]) {
                        healths[pstIdx] = 0;
                        healths[popIdx] -= 1;
                        stack.push(popIdx);
                    }
                    else {
                        healths[popIdx] = healths[pstIdx] = 0;
                    }
                }
            }
        }

        for(int health : healths)
            if(health != 0)
                result.add(health);
        
        return result;
    }
}
