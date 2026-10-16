import java.util.ArrayList;
import java.util.List;

class Solution {
    // 1. Fixed the array mapping to match standard keyboard digits 0-9
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    // 2. Changed return type to List<String> to match LeetCode's template
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base edge case: return empty list if input is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        findCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void findCombinations(String digits, int index, StringBuilder current, List<String> result) {
        // Base Case: If we have processed all digits, add the combination to our result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get letters mapped to the current digit
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];
        
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));       // Step 1: Choose
            findCombinations(digits, index + 1, current, result); // Step 2: Recurse
            current.deleteCharAt(current.length() - 1); // Step 3: Backtrack
        }
    }
}