import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        // Start with n opening and n closing brackets
        generate(result, "", n, n);

        return result;
    }

    void generate(List<String> result, String s,
                  int left, int right) {

        // All brackets are used
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        // We can add '(' if we still have some left
        if (left > 0) {
            generate(result, s + "(", left - 1, right);
        }

        // We can add ')' only when an '(' is already available
        if (right > left) {
            generate(result, s + ")", left, right - 1);
        }
    }
}