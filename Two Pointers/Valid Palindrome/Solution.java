class Solution {
    /**
     * Check if a given string is a valid palindrome, 
     * considering only alphanumeric characters and ignoring cases.
     * @param s the input string
     * @return true if the string is a valid palindrome, false otherwise
     * */
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            char chI = str.charAt(i);
            char chJ = str.charAt(j);
            if (Character.isLetterOrDigit(chI) 
            && Character.isLetterOrDigit(chJ)) {
                if (chI != chJ) return false;
                i++;
                j--;
            } else {
                if(!Character.isLetterOrDigit(chI)) i++;
                if(!Character.isLetterOrDigit(chJ)) j--;
            }
        }
        return true;
    }
}