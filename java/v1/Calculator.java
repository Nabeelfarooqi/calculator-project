import java.lang.String;
import java.util.Scanner;
public class calculatorProject
{
    private static double currentValue;   
    private static double storedValue;
    private static char currentOperator;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a value.");
        currentValue = scanner.nextDouble();
        storedValue = currentValue;
        System.out.println("Please enter an operator (+, -, *, /) or '=' to get final answer.");

        while(true){
             currentOperator = scanner.next().charAt(0);
             if(currentOperator == '='){
                 System.out.println("Result: "+storedValue);
                 scanner.close();
                 break;

             }else{
                currentValue = scanner.nextDouble();

                 switch(currentOperator){
                    case '+': storedValue = addition(currentValue, storedValue); break;   
                    case '-': storedValue = subtraction(currentValue, storedValue); break;
                    case '*': storedValue = multiplication(currentValue, storedValue); break;
                     case '/': storedValue = division(currentValue, storedValue); break;
                    default: System.out.println("Invalid Operator."); break;
                }   
             }
            


        }
        


        }
        
        private static double addition(double currentValue, double storedValue){               
        storedValue += currentValue;
        
        
        return storedValue;
    }
    
        private static double subtraction(double currentValue, double storedValue){
        storedValue -= currentValue;

        
        return storedValue;
    }
    
        private static double multiplication(double currentValue, double storedValue){
        storedValue *= currentValue;
        
        return storedValue;
    }
    
        private static double division(double currentValue, double storedValue){
        
        if(currentValue == 0){
         System.out.println("Error");
        }else{
          storedValue /= currentValue;  

        }
        
        return storedValue;
    }
    }
