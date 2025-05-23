class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int count  = 0;
        int mindiff = Integer.MAX_VALUE;

        for(int num : nums ){
            int xor = num ^ k ;
            if(xor > num ){
                count++;
                totalSum += xor;
            }else {

                totalSum += num;

            }
            mindiff = Math.min(mindiff, Math.abs(num  - xor));
        }

        if(count % 2 == 0){
            return totalSum;
        }else {
            return totalSum - mindiff;
        }
    }
}
