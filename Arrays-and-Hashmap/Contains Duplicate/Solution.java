class Solution {
    /**
     * Determines if the given array contains any duplicate elements.
     *
     * This method uses a HashSet to track the elements that have already been seen.
     * It iterates through the array, and if an element is already present in the set,
     * it returns true, indicating that a duplicate exists. Otherwise, it adds the element
     * to the set and continues. If no duplicates are found, it returns false.
     *
     * @param nums the array of integers to check for duplicates
     * @return true if any value appears at least twice in the array; false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> checkIndex = new HashSet<>();
        for(int num: nums) {
            if (!checkIndex.add(num))
                return true;
        }
        return false;
    }
}