
import java.util.*;

public class CorrectParenthesises {

    private final Stack<String> stringStack;

    public CorrectParenthesises() {
        stringStack = new Stack<>();
    }

    public boolean analyze(String s) {

        Map<String, String> parenthesises = Map.of("[", "]", "(", ")", "{", "}");
        for (int i = 0; i < s.length(); i++) {
            String stackValue = null;
            if (!stringStack.empty()) {
                stackValue = stringStack.peek();
            }
            String nextSymbol = s.substring(i, i + 1);
            if ((stackValue == null || !nextSymbol.equals(parenthesises.get(stackValue)))
                    && parenthesises.containsValue(nextSymbol)) {
                //stack is empty or top of stack does no matсh the next symbol and the next symbol is a closing parenthesis
                return false;
            } else if (parenthesises.containsKey(nextSymbol)) {
                //else - next symbol is an opening parenthesis - push to the stack
                stringStack.push(nextSymbol);
            } else if (parenthesises.containsValue(nextSymbol)) {
                //else - next symbol is a closing parenthesis - pop from the stack
                stringStack.pop();
            }
        }
        return stringStack.empty();
    }

    public static void main(String[] args) {
        CorrectParenthesises correctParenthesises = new CorrectParenthesises();
        System.out.println(correctParenthesises.analyze("[]"));
    }
}
