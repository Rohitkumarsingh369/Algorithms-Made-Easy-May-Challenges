class Solution {
    public int[] sortArray(int[] nums) {
         mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int nums[],int low,int high){
        if(high>low){
            int mid=low+(high-low)/2;
            
            mergesort(nums,low,mid);
            mergesort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }
    public void merge(int[] nums,int low,int mid,int high){
        int n1=mid-low+1;
        int n2=high-mid;
        
        int left[]=new int[n1];
        int right[]=new int[n2];
        
        for(int i=0;i<n1;i++)
            left[i]=nums[low+i];
        
        for(int j=0;j<n2;j++)
            right[j]=nums[mid+1+j];
        
        int i=0,j=0,k=low;
        
        while(i<n1&&j<n2){
            if(left[i]<=right[j]){
                nums[k]=left[i++];
            }
            else{
                nums[k]=right[j++];
            }
            k++;
        }
        while(i<n1)
            nums[k++]=left[i++];
        while(j<n2)
            nums[k++]=right[j++];
    }
}