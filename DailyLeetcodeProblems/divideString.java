class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k -1)/k;
        String[] ans = new String[size];

        int idx = 0;
        for(int i = 0;i<n;i+=k){
            int end = Math.min(i + k, n);
            String group = s.substring(i, end);
        
        // Add fill character if needed
        if(group.length() < k){
            StringBuilder sb = new StringBuilder(group);
            while(sb.length() < k){
                sb.append(fill);
            }
            group = sb.toString();
        }
        ans[idx++] = group;
        }
        return ans;
    }

}
