class Solution {
    /**
     * Valid Parentheses
     * 
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * @param s: a string
     * @return: whether the string is valid
     */
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[')
                stk.push(ch);
            else {
                if(stk.isEmpty())
                    return false;
                char popedElement = stk.pop();
                if((popedElement !='(' && ch == ')') 
                || (popedElement !='{' && ch == '}')
                || (popedElement !='[' && ch == ']'))
                    return false;
            }
        }
        return stk.isEmpty();
    }
}