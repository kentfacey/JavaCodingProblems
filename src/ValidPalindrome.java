/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        System.out.println(validPalindrome.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]+","");
        s = s.toLowerCase();
        int len = s.length() - 1;
        for(int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(len - i)) {
                return false;
            }
        }

        return true;
    }

    // Slightly more efficient
    public boolean isPalindrome2(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            char c1 = s.charAt(p1);
            if (!Character.isLetterOrDigit(c1)) {
                p1++;
                continue;
            }
            char c2 = s.charAt(p2);

            if (!Character.isLetterOrDigit(c2)) {
                p2--;
                continue;
            }

            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }
}
