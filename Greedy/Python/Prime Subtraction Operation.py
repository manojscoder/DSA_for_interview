# Problem link: https://leetcode.com/problems/prime-subtraction-operation/description
# Time: O(n * sqrt(m))
# Space: O(max(nums))
class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        primes, prev = [0, 0], 0

        for num in range(2, max(nums) + 1):
            if self.isPrime(num):
                primes.append(num)
            else:
                primes.append(primes[-1])
        
        for num in nums:
            upper = num - prev
            largestPrime = primes[upper - 1]

            if num - largestPrime <= prev:
                return False
            prev = num - largestPrime

        return True
    
    def isPrime(self, num):
        for n in range(2, int(sqrt(num)) + 1):
            if num % n == 0:
                return False
        return True
