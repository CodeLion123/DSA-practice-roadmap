class Solution {
    /**
     * Groups anagrams from the given array of strings.
     *
     * This method uses a HashMap to group strings that are anagrams of each other.
     * It calculates a unique key for each string based on the product of prime numbers
     * corresponding to each character. Anagrams will have the same key and be grouped together.
     *
     * @param strs the input array of strings
     * @return a list of lists, where each inner list contains strings that are anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<Integer,List<String>> groupMap = new HashMap<>();
        int[] freq = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for(String s:strs) {
            int key=1;
            for(int i=0; i<s.length(); i++) {
                key *= freq[s.charAt(i)-'a']; 
            }
            if(groupMap.containsKey(key)) {
                List tempArr  = groupMap.get(key);
                tempArr.add(s);
                groupMap.put(key, tempArr);
            }                
            else {
                List tempArr = new ArrayList<>();
                tempArr.add(s);
                groupMap.put(key, tempArr);
                output.add(tempArr);
            }
                
        }
        return output;
    }
}