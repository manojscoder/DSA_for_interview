// Problem link: https://leetcode.com/problems/lemonade-change/description
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0, five = 0;

        for(int dollar : bills){
            if(dollar == 5){
                five++;
            }
            else if(dollar == 10){
                if(five == 0){
                    return false;
                }
                five--;
                ten++;
            }
            else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five > 2){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
