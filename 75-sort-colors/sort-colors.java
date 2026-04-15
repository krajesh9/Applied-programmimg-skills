class Solution {
    //time : O(n), n= number of elements to loop through
    //space:O(1)

    public void sortColors(int[] nums) {
        // i have 0
        // j have 1
        // k have 2

        // logic -> if j found 0, then give it to i or if found 2, give it to k

        // ij          k      j == 2 , swap with k
        // 2  2  0  1  1      k--;

        // ij       k         j == 1
        // 1  2  0  1  2      j++;

        // i  j     k         j == 2 , swap with k
        // 1  2  0  1  2      k--;

        // i  j     k         j == 1 
        // 1  1  0  2  2      j++;

        // i     j  k         j == 0 , swap with i
        // 1  1  0  2  2      i++, j++

        //    i     jk        
        // 0  1  1  2  2      

        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while(j <= k) {
            if(nums[j] == 0) {
                swap(nums, j, i);
                i++;
                j++;
            }
            else if(nums[j] == 1) j++;
            else if(nums[j] == 2) {
                swap(nums, j, k);
                k--;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}