package solution;

public class Solution5 {
    //Brute Force: time complexity: o(n^2),
    //             space complexity:o(1)
    int left, maxLength;
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            findLongest(s, i, i);
            findLongest(s, i, i + 1);
        }

        return s.substring(left, left + maxLength);
    }
    private void findLongest(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i  - 1 > maxLength) {
            maxLength = j - i - 1;
            left = i + 1;
        }
    }
}
