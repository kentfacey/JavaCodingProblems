package HashMap;

import java.util.*;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        SortedSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }

        Iterator<Integer> iterator = set.iterator();

        int longestCount = 1;
        int count = 1;
        int previous = iterator.next();

        while (iterator.hasNext()) {
            int curr = iterator.next();
            if (previous + 1 == curr) {
                count++;
            } else {
                count = 1;
            }
            previous = curr;
            longestCount = Math.max(count, longestCount);
        }

        return longestCount;
    }



    // In the case where it breaks if there are multiple of a single variable
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (int i : nums) {
            if (sortedMap.containsKey(i)) {
                sortedMap.put(i, sortedMap.get(i) + 1);
            }
            else {
                sortedMap.put(i, 1);
            }
        }

        Set<Integer> keys = sortedMap.keySet();

        Iterator<Integer> iterator = keys.iterator();

        int longestCount = 1;
        int count = 1;
        int previous = iterator.next();

        while (iterator.hasNext()) {
            if (sortedMap.get(previous) > 1) {
                count = 1;
            }

            int curr = iterator.next();
            if (previous + 1 == curr) {
                count++;
            } else {
                count = 1;
            }
            previous = curr;
            longestCount = Math.max(count, longestCount);
        }

        return longestCount;
    }
}
