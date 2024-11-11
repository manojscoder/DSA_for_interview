// Problem link: https://leetcode.com/problems/prime-subtraction-operation/description
// Time: O(n * sqrt(m))
// Space: O(max(nums))
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = nums[0], prev = 0, upper, largestPrime;

        for(int num : nums) {
            max = Math.max(num, max);
        }

        int[] primes = new int[max + 1];

        for(int num = 2; num <= max; num++) {
            if(this.isPrime(num)) {
                primes[num] = num;
            }
            else {
                primes[num] = primes[num - 1];
            }
        }

        for(int num : nums) {
            upper = num - prev;
            largestPrime = upper > 1 ? primes[upper - 1] : 0;

            if(num - largestPrime <= prev) {
                return false;
            }

            prev = num - largestPrime;
        }

        return true;
    }

    private boolean isPrime(int num) {
        for(int n = 2; n <= Math.sqrt(num); n++) {
            if(num % n == 0) {
                return false;
            }
        }

        return true;
    }
}
