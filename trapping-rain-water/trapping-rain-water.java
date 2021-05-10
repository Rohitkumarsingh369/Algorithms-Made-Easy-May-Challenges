class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int left=0,right=n-1;
        int leftmax=0,rightmax=0,result=0;
        
        while(left<=right){
            if(rightmax<=leftmax){
                result+=Math.max(0,rightmax-arr[right]);
                rightmax=Math.max(rightmax,arr[right]);
                right--;
            }
            else{
                result+=Math.max(0,leftmax-arr[left]);
                leftmax=Math.max(leftmax,arr[left]);
                left++;
            }
        }
        
        return result;
    }
}