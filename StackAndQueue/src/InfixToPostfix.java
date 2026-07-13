
public class InfixToPostfix {
    public static int getPrecedence(char c) {
        switch (c) {
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

    public static String IntoPost(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.getPeek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.getPeek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.getPeek())) {
                    if (stack.getPeek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.getPeek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static int calculatePos(String exp) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c))
                stack.push((int) c);
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(IntoPost("((9-2)*6+7)/7"));
        System.out.println(calculatePos(IntoPost("((9-2)*6+7)/7")));
    }
}
