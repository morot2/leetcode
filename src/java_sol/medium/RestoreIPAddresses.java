package java_sol.medium;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {

        List<String> result = new LinkedList<String>();
        dfs(s, "", result, 0, 0);

        return result;
    }

    private static void dfs(final String s, String current, List<String> result, int depth, int start) {
        if (depth == 4 && start == s.length()) {
            if (!result.contains(current)) { result.add(current); }
            return;
        }

        int remainLength = s.length() - start;
        if (remainLength > (4 - depth) * 3) {
            return; }
        if (remainLength < 1) {
            return;
        }

        if(depth == 3){
            String candidate = s.substring(start, start + remainLength);
            if (valid(candidate)) {
                String added = current + getDelimiter(depth) + candidate;
                dfs(s, added, result, depth + 1, start + remainLength);
            } else {
                return;
            }
        }

        if (remainLength >= 1) {
            String candidate = s.substring(start, start + 1);
            if (valid(candidate)) {
                String added = current + getDelimiter(depth) + candidate;
                dfs(s, added, result, depth + 1, start + 1);
            } else {
                return;
            }
        }

        if (remainLength >= 2) {
            String candidate = s.substring(start, start + 2);
            if (valid(candidate)) {
                String added = current + getDelimiter(depth) + candidate;
                dfs(s, added, result, depth + 1, start + 2);
            } else {
                return;
            }
        }

        if (remainLength >= 3) {
            String candidate = s.substring(start, start + 3);
            if (valid(candidate)) {
                String added = current + getDelimiter(depth) + candidate;
                dfs(s, added, result, depth + 1, start + 3);
            } else {
                return;
            }
        }
    }

    public static String getDelimiter(int depth) {
        return depth == 0 ? "" : ".";
    }

    public static boolean valid(final String partial) {
        if (partial.length() > 1 && partial.substring(0, 1).equals("0")) { return false; }

        if (Integer.parseInt(partial) > 255) {
            return false;
        }

        if (partial.length() > 3) { return false; }

        for (int i = 0; i < partial.length(); i++) {
            if (partial.charAt(i) < 48 || partial.charAt(i) > 57) { return false; }
        }

        return true;
    }

    public static void main(String[] args) {
        restoreIpAddresses("101023");
    }
}
