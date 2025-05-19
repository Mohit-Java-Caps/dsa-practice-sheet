class Solution {
    public String triangleType(int[] nums) {
        int n = nums.length;
        int a= nums[0], b = nums[1], c = nums[2];
        if(n == 0 || n == 1 || n==2){
            return "none";
        }
        if(a +b <=c  || a+c <=b || b+c <= a){
            return "none";
        }
        
        if(nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        if(nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) return "isosceles";
        return "scalene";

    }
}
