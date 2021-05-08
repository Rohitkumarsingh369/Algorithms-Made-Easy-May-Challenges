
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int x=0;x<n/2;x++){
            for(int y=x;y<n-x-1;y++){
                int temp=matrix[x][y];
                matrix[x][y]=matrix[n-y-1][x];
                matrix[n-y-1][x]=matrix[n-x-1][n-y-1];
                matrix[n-x-1][n-y-1]=matrix[y][n-x-1];
                matrix[y][n-x-1]=temp;
            }
        }
    }
}