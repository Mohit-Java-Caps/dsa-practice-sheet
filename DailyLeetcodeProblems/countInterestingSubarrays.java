
//To efficiently solve this problem, we can:
 
//1. Transform the original array into a binary array where each element is:
 
//1 if nums[i] % modulo == k
 
//0 otherwise

//2. Compute the prefix sum of this binary array. This prefix sum represents the count of elements satisfying the condition up to the current index.
 
//3. Utilize a hash map to store the frequency of each prefix sum modulo modulo.
 
//4. Iterate through the array, and for each prefix sum, determine the number of previous prefix sums that would result in an interesting subarray ending at the current index.


class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        long ans = 0;
        int prefix = 0;

        for(int n : nums){
            if(n % modulo == k){
                prefix = (prefix + 1) % modulo;

            }
             int target = (prefix - k + modulo) % modulo;
             ans+= map.getOrDefault(target, 0);
             map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}
