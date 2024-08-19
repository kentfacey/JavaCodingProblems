package arrayOrString;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        int longestCommonPrefix = strs[0].length();
        StringBuilder sb = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            if (longestCommonPrefix == 0) return "";
            String curr = strs[i];
            longestCommonPrefix = Math.min(curr.length(), longestCommonPrefix);

            for (int j = 0; j < longestCommonPrefix; j++) {
                if (curr.charAt(j) != sb.charAt(j)) {
                    longestCommonPrefix = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, longestCommonPrefix);
    }
}
