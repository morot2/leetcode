package java_sol.easy;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        final int maxLength = Math.max(a.length(), b.length());

        int i = 0;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(i < maxLength){
            String aVal = "";
            String bVal = "";

            if(i < a.length())
                aVal = a.substring(a.length()-1-i, a.length()-i);
            else
                aVal = "0";

            if(i < b.length())
                bVal = b.substring(b.length()-1-i, b.length()-i);
            else
                bVal = "0";

            int sum = Integer.parseInt(aVal) + Integer.parseInt(bVal) + carry;
            if(sum == 3){
                result.insert(0, "1");
                carry = 1;
            } else if(sum == 2){
                result.insert(0, "0");
                carry = 1;
            } else {
                result.insert(0, sum);
                carry = 0;
            }

            i++;
        }

        if(carry == 1){
            result.insert(0, "1");
        }

        return result.toString();
    }

    public static void main(String[] args){
        addBinary("1010", "1011");
    }
}
