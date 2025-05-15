class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        
        List<String> ans = new ArrayList<>();
        if(words.length == 0) return ans;
        ans.add(words[0]);
        int prevGroup = groups[0];
        for(int i = 1;i<words.length;i++){
            if(groups[i]!= prevGroup){
                ans.add(words[i]);
                prevGroup = groups[i];
            }
        }
        return ans;
    }
}
