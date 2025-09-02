class Solution {
    /**
     * Determines if two strings are anagrams of each other.
     *
     * This method uses an integer array of size 26 to count the occurrences of each character
     * in the first string and then decrements the counts based on the characters in the second string.
     * If both strings are anagrams, all counts should return to zero.
     *
     * @param s the first string
     * @param t the second string
     * @return true if t is an anagram of s; false otherwise
     */
    public static boolean isAnagram(String s, String t) {
       int[] char26Arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char26Arr[s.charAt(i)-97]++;
        }
        for(int i=0; i<t.length(); i++) {
            char26Arr[t.charAt(i)-97]--;
        }
        for(int i:char26Arr) {
            if(i!=0) return false;
        }
        return true;
    }
}