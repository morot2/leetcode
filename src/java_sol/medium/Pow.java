package java_sol.medium;

/**
 * https://leetcode.com/problems/powx-n/
 */

public class Pow {
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        else if(n < 0){
            if( (n * -1) % 2 == 0 ){
                double result = myPow(x, n/2 * -1);
                return 1 / (result * result);
            } else {
                double result = myPow(x, n/2 * -1);
                return 1 / (result * result * x);
            }
        } else {
            if( n%2 == 0 ){
                double result = myPow(x, n/2);
                return result * result;
            } else {
                double result = myPow(x, n/2);
                return result * result * x;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
