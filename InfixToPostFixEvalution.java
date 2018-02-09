import java.util.Stack;
public class InfixToPostFixEvalution 
{
    private static boolean isOperator(char c) 
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }
    private static int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        }
        return -1;
    }
    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')||(ch>=48&&ch<=57);
    }
    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;
        for (int i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);
            if (isOperand(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') 
            {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(c)) // operator encountered
            {
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) 
    {
        System.out.println(convertToPostfix(args[0]));
    }
}