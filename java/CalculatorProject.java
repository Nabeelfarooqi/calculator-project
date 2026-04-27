import java.util.*;

public class CalculatorProject
{
    private static final Map<String, Integer> PRECEDENCE = new HashMap<>();
    static {
        PRECEDENCE.put("+", 1);
        PRECEDENCE.put("-", 1);
        PRECEDENCE.put("*", 2);
        PRECEDENCE.put("/", 2);
        PRECEDENCE.put("^", 3);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an infix expression (e.g., 3*2+5^2):");

        String userInput = scanner.nextLine();

        try{
            String postfix = shuntingYard(userInput);
            double result = evaluateRPN(postfix.split(" "));
            System.out.println("Result: " + (result % 1 == 0 ? String.valueOf((long) result) : String.valueOf(result)));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double evaluateRPN(String[] tokens){
        Stack<Double> stack = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    private static Double applyOperator(double a, double b, String token) {
        switch(token){
            case("+"): return a+b;
            case("-"): return a-b;
            case("*"): return a*b;
            case("^"): return Math.pow(a, b);
            case("/"):
                if(b == 0) throw new ArithmeticException("Division by zero");
                return a/b;
            default: throw new IllegalArgumentException("Unknown Operator " + token);
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") || token.equals("^");
    }
    private static List<String> tokenize (String input){
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i<input.length(); i++){
            char c = input.charAt(i);

            if(Character.isWhitespace(c)) continue;

            if(Character.isDigit(c) || c == '.') {
                current.append(c);
            } else {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }
        if(current.length() > 0) tokens.add(current.toString());
        return tokens;
    }

    public static String shuntingYard(String expression){
        StringBuilder output = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        List<String> tokens = tokenize(expression);
        for (String token : tokens){
            if(isOperator(token)) {
                while (!operatorStack.isEmpty()
                        && isOperator(operatorStack.peek())
                        && (PRECEDENCE.get(operatorStack.peek()) > PRECEDENCE.get(token)
                        || (PRECEDENCE.get(operatorStack.peek()) >= PRECEDENCE.get(token) && !token.equals("^")))) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty()) operatorStack.pop();
            } else {
                output.append(token).append(" ");
            }
        }

        while(!operatorStack.isEmpty()){
            output.append(operatorStack.pop()).append(" ");
        }
        return output.toString().trim();
    }
}
