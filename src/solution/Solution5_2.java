package solution;

public class Solution5_2 {
    //DP: time complexity: o(n^2),
    //         space complexity:o(n^2)
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int left = 0, max = 1;

        for (int i = 0; i < length - 1; i++) {
            dp[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int len = 2; len < length; len++) {
            for (int i = 0; i + len < length; i++) {
                if (dp[i + 1][i + len - 1] && s.charAt(i) == s.charAt(i + len)) {
                    dp[i][i + len] = true;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= left + max; j--) {
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    left = i;
                    break;
                }
            }
        }
        return s.substring(left, left + max);
    }
}
