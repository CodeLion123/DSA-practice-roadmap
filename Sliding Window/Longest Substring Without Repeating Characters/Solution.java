class Solution {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * @param s: a string
     * @return: the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int max = 0;
        while(i < s.length()) {
            
            Set<Character> hashSet = new HashSet<>();
            hashSet.add(s.charAt(i));
            int j=i+1; 
            int count = 1;
            while(j < s.length()) {
                char ch = s.charAt(j);
                if(hashSet.contains(ch)) {
                    max = Math.max(max, count);
                    break;
                }
                else {
                    hashSet.add(ch);
                    count++;
                }
                j++;
            }
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
}