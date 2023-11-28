public class OverloadedMethods {
    public static void main(String [] args) {
        //string methods
        //length() - int - how many chars
        //equals(String s) - boolean -  compare two strings to see if they're the same
        //substring(int i) - String - gives part of the string beginning at position i
        //substring(int i, int j) - String - gives part of the string from position i to
        //(and excluding) position j

        //indexOf(String s) - returns int - returns the index of the first occurrence
        //of the substring s

        System.out.println("index of a in banana:");
        System.out.println("banana".indexOf("a"));

        //when the substring is multiple chars, indexOf() returns the position
        //of the starting char
        System.out.println("index of na in banana:");
        System.out.println("banana".indexOf("na"));

        //indexOf() returns -1 if the substring isn't found
        System.out.println("index of c in banana:");
        System.out.println("banana".indexOf("c"));

        System.out.println();

        //compareTo(String s) - returns int
        //used for sequencing strings (alphabetizing or sorting)
        //a.compareTo(b)
        //returns negative if a comes sequentially before b
        //-positive if a comes after b
        //-zero if a is the same as b

        //reading from left to right, if the strings are already in order,
        //negative is returned. if they're out of order, positive is returned

        //bob comes before lake (already in order) so negative is returned
        System.out.println("bob".compareTo("lake"));

        //lake comes after bob (out of order) so positive is returned
        System.out.println("lake".compareTo("bob"));

        //same strings so zero is returned
        System.out.println("lake".compareTo("lake"));

        //the actual number doesn't matter - just look at the sign
        System.out.println("lake".compareTo("moose"));

        System.out.println("lake".compareTo("lasso"));


        //sequentially, all uppercase letters come before all lowercase letters
        System.out.println("Z".compareTo("a"));

        //there are two versions of substring()
        //-one takes one int param, the other takes two int params
        System.out.println("banana".substring(2));
        System.out.println("banana".substring(0, 2));

        //substring() is an overloaded method
        //the same method name can be defined multiple times with different parameters

        System.out.println();

        //the program knows which version of the method to call based on the
        //quantity and sequence of the arguments (values passed)
        System.out.println(max(10, 7));

        System.out.println(max(10, 20, 5));

        //depending on the sequence/type of arguments, a different version is called
        System.out.println(max(9, 5.9));

        print("something");
        print(""+5);

        //call version of print() that takes an int param
        print(5);

    }

    //return the value of the greater parameter
    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    //overloaded version of max() -
    // the parameters need to be something besides 2 ints
    public static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c)
            return b;
        return c;
    }

    //overloaded methods need to have different method signatures
    //-the params need to have a different quantity or sequence or type

    //doesn't work bc there's already a version of max with two int params
//    public static int max(int c, int d) {
//        return -1;
//    }

    //valid bc now one of the param data types has changed
    public static int max(double a, int b) {
        return -1;
    }

    //also valid - the sequence of param types is different
    public static int max(int a, double b) {
        return -1;
    }

    public static int max(int a, int b, int c, int d) {
        //you can call different overloaded versions of the same method

        //call the version with 3 params
        int maxOf3 = max(a, b, c);

        //call the version with 2 int params
        int finalMax = max(maxOf3, d);
        return finalMax;
    }

    public static void print(String s) {
        System.out.println(s);
    }

    //overload print() to accept an int
    public static void print(int i) {
        print("" + i);
    }

}
