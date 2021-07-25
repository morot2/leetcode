package java.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String num = Integer.toString(x);

        String sign = "";
        if(num.contains("-")){
            num = num.substring(1);
            sign = "-";
        }

        StringBuffer sb = new StringBuffer(num);
        String reversed = sb.reverse().toString();
        reversed = sign + reversed;

        int reversedInt = 0;
        try{
            reversedInt = Integer.parseInt(reversed);
        } catch (NumberFormatException exception) {
            return 0;
        }
        return reversedInt;
    }

}
