class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstrow = false, firstcol = false;

        for(int j = 0;j<n;j++){
            if(matrix[0][j] == 0){
                firstrow = true;
            }
        }

        for(int i = 0;i<m;i++){
            if(matrix[i][0] == 0){
                firstcol = true;
            }
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1;i<m ;i++){
            for(int j = 1 ;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstrow){
            for(int j = 0 ;j<n;j++){
                matrix[0][j] = 0;
            }
        }

        if(firstcol){
            for(int i = 0 ;i<m ;i++){
                matrix[i][0] = 0;
            }
        }

        
    }
}
