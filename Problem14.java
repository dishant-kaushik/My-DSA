Problem:
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Solution:
  
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return binaryPow(x,n);
    }
    private double binaryPow(double x, int n){
        if(n==0){
            return 1;
        }
        double halfPow = binaryPow(x, n/2);
        if(n % 2 == 0){
            return halfPow*halfPow;
        }
        else{
            return halfPow*halfPow*x;
        }
    }
}
