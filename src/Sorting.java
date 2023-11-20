public class Sorting {

    public static void main(String [] args) {
        int [] nums = {4, 3, 1, 9, 2, 3, -2, 0};
        insertionSort(nums);
        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println();
        int a = 0;
        double b = -2.7;
        String c = "something";
        boolean d = true;

        System.out.println(a + " " + b + " " + c + " " + d);

        doSomething(a, b, c, d);

        System.out.println(a + " " + b + " " + c + " " + d);


        //primitive types: int, double, boolean
        // and Strings (not primitive but acts primitive)
        //when passing primitive types, a copy of the data is used in the method
        //and the original values are not changed

        //-when passing arrays and objects (next semester), the same array is passed
        //and any changes that a method makes to the array will be seen elsewhere


        System.out.print("before calling method: ");
        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        doSomething2(nums);

        System.out.print("after calling method: ");
        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void doSomething2(int [] list) {
        for (int i = 0; i < list.length; i++)
            list[i] = 0;
    }

    //when passing arguments for parameters for a method, the values are COPIES
    //of the original, and the originals won't be changed
    public static void doSomething(int a, double b, String c, boolean d) {
        a = 432;
        b = 3.5;
        c = "dinosaur";
        d = false;

        System.out.println("in method: " + a + " " + b + " " + c + " " + d);
    }

    //like if you physically sort cards in your hand -
    //-moving from left to right, pick up a card (current) and
    //assume the cards behind current are already in sorted order.
    //-to the LEFT, see how many cards are greater than current
    //and move each of those up one index.
    //When the next card is less than current, DON'T move that card
    // and insert current in front of that smaller card
    public static void insertionSort(int []  list) {
        for (int i = 1; i < list.length; i++) {
            //use current like a temp variable so that position i is available
            //for another card to be moved up
            int current = list[i];

            //j represents the position whose value potentially moves up one position
            int j = i - 1;

            //keep looking behind i (current position) as long as it's a valid index
            //AND the card at the j position is bigger than current
            while (j >= 0 && list[j] > current) {

                //move card j up by one position
                list[j+1] = list[j];

                j--;
            }

            //after the loop, all the numbers that need to change position have been moved
            //and the current value can be inserted at position j+1
            list[j+1] = current;

            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    //iterate through list. For each position,
    // look to the right and find the smallest card available.
    //Swap the smallest card and the card at the current position
    public static void selectionSort(int [] list) {
        for (int i = 0; i < list.length; i++) {
            int smallestI = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[smallestI])
                    smallestI = j;

            int temp = list[smallestI];
            list[smallestI] = list[i];
            list[i] = temp;

        }
    }

}
