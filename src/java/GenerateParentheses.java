package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        int l = n - 1, r = n;

        List<String> results = new ArrayList<>();
        String result = "(";
        dfs(l, r, result, results);

        return results;
    }

    public static void dfs(int l, int r, String result, List<String> results){
        if(l == 0 && r == 0){
            results.add(result);
            return;
        }

        if(l > 0)
            dfs(l-1, r, result + "(", results);
        if(r > l)
            dfs(l, r-1, result + ")", results);
    }

    public static void main(String[] args){
        List<String> results = generateParenthesis(3);

        for(String result : results)
            System.out.println(result);
    }
}
