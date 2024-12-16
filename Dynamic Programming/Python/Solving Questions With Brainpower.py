# Problem link: https://leetcode.com/problems/solving-questions-with-brainpower/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        DP = [0] * len(questions)

        for index in range(len(questions) - 1, -1, -1):
            points, brainPower = questions[index]
            withQ = withoutQ = 0

            if index + brainPower + 1 < len(questions):
                withQ = DP[index + brainPower + 1]
            if index + 1 < len(questions):
                withoutQ = DP[index + 1]
            
            DP[index] = max(points + withQ, withoutQ)
        
        return DP[0]
