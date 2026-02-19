class Solution {
    public void moveZeroes(int[] nums) {
      int start = 0;
        int end = start + 1;

        while(start < nums.length && end < nums.length){
            if(nums[start]==0 && nums[end]!=0){
                swap(start,end,nums);
                start++;
                end++;
            }
            else if(nums[start]!=0){
             start++;
             end++;
            }
            else{
                end++;
            }
        }
       
   }


   private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }
}