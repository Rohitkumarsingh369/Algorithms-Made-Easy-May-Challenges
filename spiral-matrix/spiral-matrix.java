class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> list=new ArrayList<>();
        
        int m=a.length;
        int n=a[0].length;
        int k=0, l=0,i;
        /*
        k -> starting row index
        m -> ending row ndex
        l -> starting column index
        n -> ending column index
        */
        
        while(k<m && l<n){
            //top row
        for(i=l;i<n;i++)
            list.add(a[k][i]);
        k++;
        
        //last column
        for(i=k;i<m;i++)
            list.add(a[i][n-1]);
        
        n--;
        
        //bottom row
        if(k<m){
            for(i=n-1;i>=l;i--)
                list.add(a[m-1][i]);
            m--; 
        }
        //first column
        if(l<n){
            for(i=m-1;i>=k;i--)
                list.add(a[i][l]);
            l++; 
        }
        }
        
        return list;
    }
}