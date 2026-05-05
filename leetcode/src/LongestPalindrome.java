public class LongestPalindrome {
    void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();

        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int[] ans = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            int evenLength = expand(i, i + 1, s);
            int len = Math.max(oddLength, evenLength);
            if (len > ans[1] - ans[0] + 1) {
                ans[0] = i - (len - 1) / 2;
                ans[1] = i + len / 2;
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }

    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
