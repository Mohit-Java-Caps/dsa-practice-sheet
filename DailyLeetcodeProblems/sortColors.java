
// Using Dutch flagship Algorithm(3 pointers)
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                    high--;
            }
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
