# Problem link: https://leetcode.com/problems/student-attendance-record-ii/description
# Time: O(n)
# Space: O(1)
class Solution:
    def checkRecord(self, n: int) -> int:
        tmp, MOD = {(0, 0) : 1, (0, 1) : 1, (0, 2) : 0,
                    (1, 0) : 1, (1, 1) : 0, (1, 2) : 0}, 10 ** 9 + 7
        # Bottom - up approach (DP)
        for i in range(n - 1):
            res = {}
            # for 'P'
            res[(0, 0)] = ((tmp[(0, 0)] + tmp[(0, 1)]) % MOD + tmp[(0, 2)]) % MOD
            res[(1, 0)] = ((tmp[(1, 0)] + tmp[(1, 1)]) % MOD + tmp[(1, 2)]) % MOD

            # for 'L'
            res[(0, 1)] = tmp[(0, 0)] % MOD
            res[(0, 2)] = tmp[(0, 1)] % MOD
            res[(1, 1)] = tmp[(1, 0)] % MOD
            res[(1, 2)] = tmp[(1, 1)] % MOD

            # for 'A'
            res[(1, 0)] += ((tmp[(0, 0)] + tmp[(0, 1)]) % MOD + tmp[(0, 2)]) % MOD
            tmp = res

        return sum(tmp.values()) % MOD
