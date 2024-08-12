package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int p1 = -1;
        int longestSubstring = 0;
        Map<Character, Integer> found = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (found.containsKey(c)) {
                p1 = Math.max(p1, found.get(c));
            }

            longestSubstring = Math.max(longestSubstring, i-p1);

            found.put(c, i);
        }

        return longestSubstring;
    }
}
