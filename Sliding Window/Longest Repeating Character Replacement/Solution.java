class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int maxCount = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int end=0; end<s.length(); end++) {
            char ch = s.charAt(end);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
            maxCount = Math.max(freqMap.get(ch), maxCount);
            while((end-start+1)-maxCount > k) {
                char chStart = s.charAt(start);
                freqMap.put(chStart, freqMap.get(chStart)-1); 
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}