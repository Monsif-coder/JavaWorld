
import java.util.Set;

public class calc{

    // Set to validate required operators
    private static final Set<String> ValidOperators = Set.of("+","-","*", "/");
    public static void main(String[] argc){

        // check for valid number of arguments
        if(argc.length != 3){
            System.err.println("Error: please provide three arguments");
            System.exit(1);
        }

        // declaration of numbers variables
        double num1 = 0, num2 = 0;
        String operator = argc[1];

        // Parsing arguments 0 && 2 as numbers
        try{
            num1 = Double.parseDouble(argc[0]);
            num2 = Double.parseDouble(argc[2]);

        }catch (NumberFormatException e){
            e.getMessage();
            System.err.println("Error: arguments must be valid numbers");
            System.exit(1);
        }

        // Check for valid operator

        if(!ValidOperators.contains(operator)){
            System.out.println("wrong operator. Please provide either a +, -, * or /");

            System.exit(1);
        }

        // Proceed with the calculation logic
        double result;
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        }

        // Print out the calculation result

        System.out.println("result is " + result);



    }


}
