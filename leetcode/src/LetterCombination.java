import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    private static final String[] PHONE = {
            "",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz",//9
    };

    static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        System.out.println(lc.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder stringBuilder, List<String> result) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        String s = PHONE[digits.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            backtrack(digits, index + 1, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }
}
