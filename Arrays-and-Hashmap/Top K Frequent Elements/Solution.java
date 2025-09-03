class Solution {
    /**
     * @param nums: an array of integers
     * @param k: an integer
     * @return: the top k frequent elements
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> maxFreqArr = new ArrayList<>();
        for(int num: nums) {
            if(freqMap.containsKey(num))
                freqMap.put(num,freqMap.get(num)+1);
            else
                freqMap.put(num, 1);
        }
        // 2) Bucket by frequency: index = frequency, value = list of numbers with that frequency
        // Max possible frequency is nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int num = e.getKey(), freq = e.getValue();
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(num);
        }

        // 3) Collect from highest frequency down
        List<Integer> result = new ArrayList<>();
        for (int f = buckets.length - 1; f >= 1 && result.size() < k; f--) {
            if (buckets[f] == null) continue;
            // Optional: sort to have a consistent order among ties
            // Collections.sort(buckets[f]);
            for (int num : buckets[f]) {
                result.add(num);
                if (result.size() == k) break;
            }
        }

        // If k > unique count, return only what we found
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) res[i] = result.get(i);
        return res;
    }
}