package java_sol.easy;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry == 0)
            return digits;
        else {
            int[] expended = new int[digits.length + 1];
            expended[0] = carry;

            for (int i = 0; i < digits.length; i++)
                expended[i + 1] = digits[i];

            return expended;
        }
    }

    public static void main(String[] args){
        plusOne(new int[]{9});
    }
}
