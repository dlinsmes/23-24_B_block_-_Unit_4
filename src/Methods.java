public class Methods {
    public static void main(String [] args) {

        //write code that will calculate the
        //sum of values between 2 provided numbers
        //ex: 4 and 8 --> 4 + 5 + + 6 + 7 + 8
        int small = 4;
        int big = 8;
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum = sum + i;
        }
        System.out.println("sum between 4 and 8 is " + sum);

        //to do the same thing later, you would need to rewrite
        //the code with different values for small and big

        //methods (aka functions) let you define reusable code

        //when you call (use) a method that returns data, you should either
        //save the return value to a variable or print it out
        //-ALSO, if there are defined parameters for the method, pass (provide)
        //values that match the quantity and data types defined
        int sum4_8 = sumBetween(4, 8);
        System.out.println("sumBetween(4, 8) is " + sum4_8);

        //method calls that return values can be placed directly in print statements
        System.out.println("sumBetween(5, 10) is " + sumBetween(5, 10));

        //function calls that return can be treated like variables

        //if you don't save or print or otherwise use the return value, it gets lost
        //(but the method DOES run)
        sumBetween(20, 30);

        //10.5 isn't a valid value to pass to the method because it doesn't
        //match the defined parameter type (int)
        //int sum2 = sumBetween(10.5, 30);

        //this works bc 10.5 gets cast to an int, which matches the defined
        //parameter type
        int sum2 = sumBetween((int)10.5, 30);

        //factorial() only defines a single int param
        System.out.println("5! is " + factorial(5));

        //doesn't work bc this tries to pass 2 values
        // instead of the defined one value
        //factorial(5, 10);


        //method calls can be passed to other calls
        //factorial() returns an int, which is the param type for sumBetween
        int sum3 = sumBetween(factorial(5), factorial(8));
        System.out.println(sum3);

        print("this is a sentences that doesn't use system.out.println");

        //doesn't work because the param is defined as a string
        //print(6);

        //concatenate a non-string to a string to be used for the method call
        print("" + 6);

        //same as
        String num = "" + 7;
        print(num);

        //no params = no values to pass
        duckduckGoose();

        //this is a void method - can't save to a variable (no return value)
        //String s = duckduckGoose();

        //print(duckduckGoose());

        //System.out.println(duckduckGoose());

        //treat method call like a variable
        if (coinFlipIsHeads() == true) {
            print("heads");
        }
        else {
            print("tails");
        }

    }

    //-for now, all methods start with public static
    //-int is the return type - the method must produce a value of
    // the defined type
    //-void is a valid return type, which means the method doesn't
    //return/produce any output data (like main())
    //sumBetween is the method name
    //small and big are parameters - like variables that get used in the method
    //that modify what the method does
    public static int sumBetween(int small, int big) {

        //treat the parameters like variables that already have values
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum = sum + i;
        }

        //the method must return data that is an int
        // (according to the defined return type)
        return sum;
    }

    //calculate and return the factorial of n
    //-factorial is n * ( n-1) * (n-2) * ... * 1
    public static int factorial(int n) {
        int product = 1;
        for (int i = n; i > 0; i--) {
            product = product * i;
        }
        return product;
    }

    //void return means no data is returned/produced
    public static void print(String s) {
        //don't add a return statement to void methods
        //return -1;
        System.out.println(s);
    }

    //methods don't NEED to have parameters
    public static void duckduckGoose() {
        //print some random number of "duck", then print "goose"
        int rand = (int)(Math.random() * 10);
        for (int i = 0; i < rand; i++) {
            //methods can be called from different methods
            print("duck");
        }
        print("goose");

    }

    //return true if the result of a coin flip is heads, false otherwise
    public static boolean coinFlipIsHeads() {
        double r = Math.random();

        //as soon as a method reaches a return statement, nothing after
        //that line will run

        //a method can only return one value

        if (r < 0.5) {
            return true;
        }
        //this works bc if r is .2, the method returns true and nothing else
        //will run

        //when the condition isn't true, the only other option is false (not heads)
        return false;
    }
}
