class Solution {
    public void solveSudoku(char[][] grid) {
        if (solvesuduko(grid, 0, 0))
			   print(grid);
			
    }
    public static boolean solvesuduko(char [][]grid,int row,int col) {
		
		if(row==grid.length-1 && col==grid[0].length)
			return true;
		
		if(col==grid[0].length)
		{
			row++;
			col=0;
		}
		
		if(grid[row][col]!='.')
			return solvesuduko(grid,row,col+1);
		
		for(int num=1;num<10;num++) {
             char tmp = Character.forDigit(num, 10);
			if(ifsafe(grid,row,col,tmp)) {
				grid[row][col]=tmp;
				
				if(solvesuduko(grid,row,col))
					return true;
			}
			grid[row][col]='.';
		}
		return false;
	}
    public static boolean ifsafe(char [][]grid,int row,int col,char num) {
		
		for(int i=0;i<=8;i++) {
			if(grid[row][i]==num)
				return false;
		}
		for(int i=0;i<=8;i++) {
			if(grid[i][col]==num)
				return false;
		}
		
		int startrow=row-row%3;
		int startcol=col-col%3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(grid[i+startrow][j+startcol]==num)
					return false;
			}
		}
			
		return true;
	}
	public static void print(char [][]grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
}