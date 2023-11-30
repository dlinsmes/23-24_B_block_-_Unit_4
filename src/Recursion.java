public class Recursion {

    public static void main(String [] args) {
        System.out.println(exponent(2, 1));
        System.out.println(expRecursive(2, 1));

        countDownFrom(5);
        System.out.println();
        countUpTo(5);
        System.out.println();

        System.out.println(fibLoop(20));
        System.out.println(fib(20));

    }

    public static int exponent(int base, int pow) {
        int ans = 1;
        for (int i = 0; i < pow; i++) {
            ans *= base;
        }
        return ans;
    }

    //a recursive method is a method that contains a
    //call to itself
    //-use recursive methods when you can take a large
    //problem and break it down into smaller pieces

    //2^4 = 2 * 2 * 2 * 2
    //    = 2 * 2^3
    //2^3 = 2 * 2^2
    //2^2 = 2 * 2^1
    //2^1 = 2 * 2^0
    //2^0 = 1
    //b^p = b * b^(p-1)
    //b^0 = 1

    public static int expRecursive(int b, int p) {
        //base case - simplest form of the problem
        //where the solution is easily found
        //-the base case should NOT make a recursive
        //method call
        if (p == 0)
            return 1;
        //recursive case - problem can still be broken down
        //and you call the method again
        else
            return b * expRecursive(b, p-1);
    }

    //if n is 5, print 5 4 3 2 1 0
    public static void countDownFrom(int n) {
        if (n == 0) {
            System.out.print(n);
        }
        else {
            System.out.print(n + " ");
            countDownFrom(n-1);
        }
    }

    //if n is 5, print 0 1 2 3 4 5
    public static void countUpTo(int n) {
        if (n == 0)
            System.out.print(n + " ");
        else {
            countUpTo(n-1);
            //the current n value can't print until the
            //recursive call finishes
            System.out.print(n + " ");
        }
        //0 is the first number printed bc all other calls are waiting
        //until the base case is reached before they can print their own numbers
    }

    //any recursive method can be written using loops instead
    //-after this unit, you never HAVE to use recursion on written code (incl FRQS and AP)
    //-you DO need to know how to read recursion for MC

    //fibonacci numbers
    // 1 1 2 3 5 8 13 21
    // the first two numbers in the sequence are 1
    //every number after that is the sum of the previous two numbers
    //in the sequence
    //f(1) = 1
    //f(2) = 1
    //f(3) = f(1) + f(2)
    //f(n) = f(n-2) + f(n-1)

    //this returns the nth number in the sequence
    //if n is 6, returns 8
    //if n is 7, returns 13
    public static int fib(int n) {
        //base case bc the first two numbers are 1
        if (n == 1 || n == 2)
            return 1;

        //recursive case - apply the formula of adding the prev two numbers
        else
            return fib(n-2) + fib(n-1);
    }

    //try to write a functionally identical method
    // using loops instead of recursion
    public static int fibLoop(int n) {
        int prev2 = 0;
        int prev1 = 0;
        int current = 1;
        for(int i = 2; i <= n; i++) {
            prev2 = prev1;
            prev1 = current;
            current = prev2 + prev1;
        }
        return current;

    }

}
