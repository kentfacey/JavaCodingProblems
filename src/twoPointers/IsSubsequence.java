package twoPointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) {
            return true;
        }

        char[] cs = s.toCharArray();

        int p = 0;

        for (char c : t.toCharArray()) {
            if (c == cs[p]) {
                p++;
            }
            if (p == cs.length) {
                return true;
            }
        }

        return false;
    }
}
