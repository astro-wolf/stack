import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        boolean verdict = backspaceStringCompare.backspaceCompare("y#fo##f","y#f#o##f");
        System.out.print(verdict);
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(char s : S.toCharArray()) {
            if(s == '#' && !sStack.isEmpty())
                sStack.pop();
            else if (s != '#')
                sStack.push(s);
        }
        for(char t : T.toCharArray()) {
            if(t == '#' && !tStack.isEmpty())
                tStack.pop();
            else if (t != '#')
                tStack.push(t);
        }
        if(sStack.isEmpty() && tStack.isEmpty())
            return true;
        while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if(sStack.pop() != tStack.pop())
                return false;
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }

}
