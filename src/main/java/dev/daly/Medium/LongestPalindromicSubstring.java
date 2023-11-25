package dev.daly.Medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("ababab"));

    }


    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = startFromMiddle(s, i, i);
            int len2 = startFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int startFromMiddle(String s, int i, int i1) {
        if (s == null || i > i1) return 0;
        while (i >= 0 && i1 < s.length() && s.charAt(i) == s.charAt(i1)) {
            i--;
            i1++;
        }
        return i1 - i - 1;
    }


}
