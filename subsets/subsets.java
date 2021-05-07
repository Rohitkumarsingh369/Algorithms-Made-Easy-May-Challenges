class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return result;
        
        dfs(result,new ArrayList<Integer>(),nums,0);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) {
        // create a copy and add into result
        result.add(new ArrayList<>(subset));
    
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}