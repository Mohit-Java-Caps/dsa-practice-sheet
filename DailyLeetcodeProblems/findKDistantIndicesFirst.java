class Solution {
    public List<Integer> findKDistantIndicesFirst(int[] nums, int key, int k) {
        Set<Integer> ans = new TreeSet<>();

        for(int j = 0;j<nums.length;j++){
            if(nums[j] == key){
                int start = Math.max(0,j-k);
                int end  = Math.min(nums.length-1, j+ k);
                for(int i = start ;i<=end;i++){
                    ans.add(i);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
