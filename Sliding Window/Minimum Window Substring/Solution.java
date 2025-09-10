class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char ch: t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        int left = 0;
        int right = 0;
        
        
        int minLeft = -1;
        int minRight = -1;
        int minCount = Integer.MAX_VALUE;
        while(right<s.length()) {
            char ch =  s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(isMatched(tMap, sMap)) {
                    if(minCount > right-left+1) {
                        minCount = right-left+1;
                        minLeft = left;
                        minRight= right;
                    }
                   
                while(left < right) {
                    char leftCh = s.charAt(left);
                    sMap.put(leftCh,sMap.get(leftCh)-1);
                    left++;
                    if(isMatched(tMap, sMap)){
                        
                        if(minCount > right-left+1) {
                            minCount = right-left+1;
                            minLeft = left;
                            minRight= right;
                            
                        }
                    } else break;
                    
                }
            }   
            right++;

        }
        if(minLeft<0) return "";
        return s.substring(minLeft,minRight+1);
    }
    private  boolean isMatched(Map<Character, Integer> tMap, Map<Character, Integer> sMap){
        for(Map.Entry<Character, Integer> e : tMap.entrySet()) {
            char key=e.getKey();
            int value=e.getValue();
            if(!sMap.containsKey(key) || sMap.get(key) < value)
                return false;
        }
        return true;
    }
}