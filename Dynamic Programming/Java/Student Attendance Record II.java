// Problem link: https://leetcode.com/problems/student-attendance-record-ii/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int checkRecord(int n) {
        int[][] tmp = new int[2][3], res = new int[2][3];
        tmp[0][0] = 1;
        tmp[0][1] = 1;
        tmp[1][0] = 1;

        int MOD = 1000000007, result = 3;

        for(int i = 1; i < n; i++){
            result = 0;
            // for 'P'
            res[0][0] = ((tmp[0][0] + tmp[0][1]) % MOD + tmp[0][2]) % MOD;
            res[1][0] = ((tmp[1][0] + tmp[1][1]) % MOD + tmp[1][2]) % MOD;

            // for 'L'
            res[0][1] = tmp[0][0] % MOD;
            res[0][2] = tmp[0][1] % MOD;
            res[1][1] = tmp[1][0] % MOD;
            res[1][2] = tmp[1][1] % MOD;

            // for 'A'
            res[1][0] = (res[1][0] + ((tmp[0][0] + tmp[0][1]) % MOD + tmp[0][2]) % MOD) % MOD;

            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    tmp[j][k] = res[j][k];
                    result = (result + tmp[j][k]) % MOD;
                }
            }
        }
        
        return result;
    }
}
