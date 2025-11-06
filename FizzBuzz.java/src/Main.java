public class FizzBuzz{

    public static void main(String[] argc) {

        // Print numbers from 1 to 100
        for(int i = 1 ; i <= 100; i++){

            // Print current number
            System.out.println("" + i);

            // Check if number is divisible by BOTH
            if( i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");

            }else if (i % 3 == 0){
                System.out.println("Fizz");

            }else if(i % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println("" + i);
            }


        }


    }
}