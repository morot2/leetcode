package java_sol.medium;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {

                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i+j] += sum;

                if(result[i+j] >= 10 && i+j != 0){
                    result[i+j-1] += result[i+j] / 10;
                    result[i+j] = result[i+j] % 10;
                }
            }
        }

        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i <= num1.length() + num2.length() - 2; i++)
            resultStr.append(result[i]);

        return resultStr.toString();
    }

    public static void main(String[] args){
        System.out.println(multiply("123","456"));
    }
}
