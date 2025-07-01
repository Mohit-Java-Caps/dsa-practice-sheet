class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 1; // original string itself is valid 

        int i = 0;
        while(i< n){
            int j = i;
            while(j < n && word.charAt(i) == word.charAt(j)){
                j++;
            }
            int len = j-i;
            if(len>=2){
                count += (len-1);
            }
            i = j;
        }
        return count;
    }
}
