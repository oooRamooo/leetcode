import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(2));
        System.out.println(s.generateParenthesis(1));
    }

    // DFS / Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder curr, int open, int close, int n) {
        if (curr.length() == n * 2) {
            result.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            backtrack(result, curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(')');
            backtrack(result, curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
