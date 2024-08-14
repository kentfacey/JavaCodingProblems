package slidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int minSize = Integer.MAX_VALUE;
        int total = 0;
        while (p2 < nums.length) {
            int curr = nums[p2];
            total += curr;

            while (total-nums[p1] >= target) {
                total -= nums[p1];
                p1++;
            }

            if (total >= target) {
                minSize = Math.min(minSize, p2 - p1 + 1);
            }

            p2++;
        }

        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }
        return minSize;
    }
}
