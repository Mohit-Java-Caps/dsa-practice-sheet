class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3){
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        char prev= s.charAt(0);
        sb.append(prev);
        int count = 1;

        for(int i = 1;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == prev){
                count++;
                if(count < 3){
                    sb.append(curr);
                }
            }else{
                prev = curr;
                count = 1;
                sb.append(curr);

            }
        }
        return sb.toString();
    }
}
