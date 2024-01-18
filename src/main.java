import java.util.Stack;

public class main {

    public static void main(String[] args) {
        System.out.println(mathConvert("(1 + ((2 + 3) * (4 * 5)))"));
    }

    public static String mathConvert(String mathProblem) {
        // First we would remove all the white space in the string
        mathProblem.replaceAll("\\s+", "");

        // Creates the stacks for the numbers and operators
        Stack<String> numbersStack = new Stack<String>();
        Stack<String> operatorsStack = new Stack<String>();

        // For each char in the string
        for (int i = 0; i < mathProblem.length(); i++) {
            char c = mathProblem.charAt(i);

            // If the char is a number, add it to the numbers stack
            if (Character.isDigit(c)) {
                numbersStack.add(String.valueOf(c));
            }
            // Else if the character is ')', add it to the operator
            else if (c == ')') {
                // Saves num1 and num2 and convert them from char into int
                int num1 = Integer.parseInt(numbersStack.pop());
                int num2 = Integer.parseInt(numbersStack.pop());
                // Gets the operator as well
                String operator = operatorsStack.pop();
                int equals = 0;

                // Checks which operator it is
                switch (operator) {
                    case "/":
                        equals = num1 / num2;
                        break;
                    case "*":
                        equals = num1 * num2;
                        break;
                    case "+":
                        equals = num1 + num2;
                        break;
                    case "_":
                        equals = num1 - num2;
                        break;
                }

                // Once the numbers are calculated, we would add them back to the numbersStack which converted back to a string
                numbersStack.add(Integer.toString(equals));
            }
            // else if it's one of the following operators, we would add them to the operatorsStack
            else if (c == '/' || c == '*' || c == '+' || c == '-') {
                {
                    operatorsStack.add(String.valueOf(c));
                }
            }
        }
        // returns the top of the numbersStack which should be the only number left which is the answer
        return numbersStack.peek();
    }
}
