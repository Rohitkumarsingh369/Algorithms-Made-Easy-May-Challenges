class Solution {
    public int singleNumber(int[] nums) {
        int visitedOnce = 0, visitedTwice = 0;
    
    for(int i : nums){
        
        visitedOnce = (visitedOnce ^ i) & ~visitedTwice;
        visitedTwice = (visitedTwice ^ i) & ~visitedOnce;
    }
    
    return visitedOnce;
    }
}