class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
		
		// find if an index with the target exsts
        int index = binarySearch(nums, target, start, end);
        
        if (index == -1) {
            return new int[] {-1, -1};
        }

		// find lowest index of that target by continuing to binary search lower 
        int lowest = index;
        while (lowest >= 0) {
            int lower = binarySearch(nums, target, start, lowest-1);   
            if (lower == -1) break;
            lowest = lower;
        }
        
		// find highest index of that target by continuing to binary search higher 
        int highest = index;
        while (highest <= end) {
            int higher = binarySearch(nums, target, highest+1, end);   
            if (higher == -1) break;
            highest = higher;
        }
        
        return new int[] {lowest, highest};
    }
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}