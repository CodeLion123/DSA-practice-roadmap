class MedianFinder {
    /**
     * Time: O(n) for addNum, O(1) for findMedian
     * Space: O(n)
     * where n is the number of elements in the data structure
     * Approach: Maintain a sorted list and use binary search to insert new elements
     * into their correct position
     * // This is not the optimized solution. The optimized solution uses two heaps
     * to maintain the lower and upper halves of the data stream.
     */
    List<Integer> arr;
    public MedianFinder() {
        this.arr = new ArrayList<>();
    }
    
    /**
     * @param num The number to be added to the data structure
     * @return void
     */
    public void addNum(int num) {
        insertIntoSortedList(num);
    }
    
    /**
     * @return The median of all elements so far
     */
    public double findMedian() {
        int len = arr.size();
        int mid = len/2;
        // System.out.println("nid: "+mid);
        if (len % 2 == 0){
            // System.out.println("arrnid: "+arr.get(mid));
            return (double)(arr.get(mid)+arr.get(mid-1))/2; }
        else
            return (double)arr.get(mid);
    }
    public void insertIntoSortedList(int element) {
        int index = Collections.binarySearch(this.arr, element);

        if (index < 0) {
            index = -index - 1; // Calculate the correct insertion point
        }
        this.arr.add(index, element);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */