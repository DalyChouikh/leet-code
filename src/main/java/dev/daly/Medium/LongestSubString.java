package dev.daly.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Expected output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // Expected output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // Expected output: 3
        System.out.println(lengthOfLongestSubstring("")); // Expected output: 0

    }

    private static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
