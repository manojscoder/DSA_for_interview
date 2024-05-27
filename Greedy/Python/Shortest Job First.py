# Time: O(nlogn)
# Space: O(n) for sorting
class Solution:
  def shortestJobFirst(self, nums: List[int]) -> int:
    nums.sort()
    total_time = waiting_time = 0

    for i in range(1, len(nums)):
        waiting_time = (waiting_time + nums[i - 1])
        total_time += waiting_time
      
    return total_time // len(nums)
