// Time: O(nlogn)
// Space: O(n) for sorting
class Solution{
  public int shortestJobFirst(int[] nums){
    Arrays.sort(nums);
    int total_time = 0, waiting_time = 0;
    for(int i = 1; i < nums.length; i++){
      waiting_time += nums[i - 1];
      total_time += waiting_time;
    }
    return (int)(total_time / nums.length);
  }
}
