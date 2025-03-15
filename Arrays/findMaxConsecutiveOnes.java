// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Example 1:
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

// Example 2:
// Input: nums = [1,0,1,1,0,1]
// Output: 2
 

// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
  
class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int ans = 0;
        int count = 0;
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        return Math.max(ans, count);
    }
}
