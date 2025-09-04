class Solution {
    /**
     * Find the length of the longest consecutive elements sequence in an unsorted array.
     * This method runs in O(n) time and uses O(n) space.
     * @param nums the input array of integers
     * @return the length of the longest consecutive elements sequence
     * */
    public static int longestConsecutive(int[] nums) {
		int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
		int longest = 0;
        int cnt=0;
		for(int a : nums)
        {
            max = Math.max(max,a);
            min = Math.min(min,a);
        }
		if(max<200000)
        {
            boolean b[] = new boolean[max-min+1];
            for(int i : nums)
            {
                b[i-min]=true;
            }
            for(boolean val :b  )
            {
                if(val)
                    cnt++;
                else
                {   
                    longest =Math.max(cnt,longest);
                    cnt=0;
                } 
            }
             longest =Math.max(cnt,longest);
        } else {

			Set<Integer> set = new HashSet<>();
			for (int x : nums) set.add(x);
			for (int x : set) {
				// Only start counting at the beginning of a run
				if (!set.contains(x - 1)) {
					int len = 0;
					int cur = x;
					while (set.contains(cur)) {
						len++;
						cur++;
					}
					longest = Math.max(longest, len);
				}
			}
			
		}
		return longest;
    }
}