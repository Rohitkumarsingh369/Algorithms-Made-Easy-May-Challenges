class Solution {
    public int reverse(int n) {
        int a=n;
        int d=0;
        long rev=0;
        while(a!=0){
            d=a%10;
            rev=rev*10+d;
            a=a/10;
        }
        int result=((rev>=Integer.MAX_VALUE || rev<=Integer.MIN_VALUE))?(0):((int)rev);
        return result;
    }
}