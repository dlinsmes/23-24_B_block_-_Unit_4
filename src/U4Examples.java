public class U4Examples {

    public static void main(String [] args) {
        int a = 7;
        double b = 32.9;
        boolean c = false;
        String d = "dinosaur";
        int [] nums = {1, 2, 3, 4, 5};

        System.out.println(a + " " + b + " " + c + " " + d);

        blah(a, b, c ,d);

        System.out.println(a + " " + b + " " + c + " " + d);

        for (int n: nums)
            System.out.print(n + " ");
        System.out.println();

        blahblah(nums);

        for (int n: nums)
            System.out.print(n + " ");
        System.out.println();

    }
    public static void blah(int q, double w, boolean e, String r) {
        q = 0;
        w = 0.0;
        e = true;
        r = "blah";
    }
    public static void blahblah(int [] t) {
        for (int i = 0; i < t.length; i++)
            t[i] = (int)(Math.random() * 10);
    }


}
