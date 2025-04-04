package leetcode.solutions;

import java.util.Set;

public class Question2 {
    public static void main(String[] args) {
        String S = "abpplee";
        Set<String> D = Set.of("able","ale","apple","bale","kangaroo");

        String result = longestSubSequence(S,D);
        System.out.println(result);
    }

    public static String longestSubSequence(String S, Set<String> D) {
        String longestString = "";

        for (String str : D) {
            if(isSubsequence(S,str) && str.length()>longestString.length()){
                longestString = str;
            }
        }
        return longestString;
    }

    public static boolean isSubsequence(String S, String T) {
        int i = 0, j = 0;
        while (i < S.length() && j < T.length()) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == T.length();
    }
}
