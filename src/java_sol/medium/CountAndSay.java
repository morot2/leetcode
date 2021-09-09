package java_sol.medium;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    static String[] mem = new String[31];
    public static String countAndSay(int n) {
        mem[1] = "1";

        for (int i = 2; i <= n; i++) {
            mem[i] = say(mem[i-1]);
        }

        return mem[n];
    }

    private static String say(String num) {
        String result = "";
        String last = "";

        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            String str = num.substring(i, i+1);

            if(last.equals("")){
                last = str;
                count++;
            } else if(last.equals(str)){
                count++;
            } else {
                result = result + count + last;
                last = str;
                count = 1;
            }
        }

        result = result + count + last;

        return result;
    }

    public static void main(String[] args){
        countAndSay(6);
    }
}
