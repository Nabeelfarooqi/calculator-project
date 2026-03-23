/**
 * Write a description of class calculatorProject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Stack;
import java.util.Scanner;
public class calculatorProject
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an RPN expression (e.g., 3 5 2 * +):");
        System.out.println("Seperate all tokens with spaces.");



        String userInput = scanner.nextLine();


        try{
            double result = evaluateRPN(userInput.split(" "));
            System.out.println("Result: "+result);
        }catch(Exception e){
            System.out.println("Error evaluating RPN expression: " + e.getMessage());

        }

        scanner.close();

    }
    public static double evaluateRPN(String[] tokens){
        Stack<Double> stack = new Stack<>();

        for(String token:tokens){
            if(isOperator(token)){
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(a, b, token));
            }else{
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
            case("/"):
                if(b == 0) throw new ArithmeticException("Division by zero");
                return a/b;
            default: throw new IllegalArgumentException("Unknown Operator " +token);

        }

    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }
}
