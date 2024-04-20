// Time: O(n ^ 2)
// Space: O(n), for sorting at the backend
// Problem link: https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left, right, total;

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                left = i + 1;
                right = nums.length - 1;
                total = 0 - nums[i];
                while(left < right){
                    if(nums[left] + nums[right] == total){
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[left]);
                        lst.add(nums[right]);
                        result.add(lst);
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] < total){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
