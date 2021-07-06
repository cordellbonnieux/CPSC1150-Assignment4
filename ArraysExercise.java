import java.util.*;
public class ArraysExercise {
    public static void main(String[] args) {

        // create scanner obj
        Scanner input = new Scanner(System.in);

        // Question 1
        int[] arr = getArray(input);

        // Question 2
        printArray(arr);

        // Question 3
        System.out.println("The largest number is: " + findMax(arr));

        // Question 4
        System.out.println("The smallest number is: " + findMin(arr));
        
        // Question 5
        System.out.println("The index of the largest number is: " + findMaxIndex(arr));

        // Question 6
        System.out.println("The index of the smallest number is: " + findMinIndex(arr));

        // Question 7
        System.out.println("Is this array sorted in ascending order? " + isSortedAscend(arr));

        // Question 8
        System.out.println("Is this array sorted in descending order? " + isSortedDescend(arr));

    }
    /** 
     * Question 1
     * Write a method named getArray that asks user to input the array size n, then initializes
     * an array of n integers from user input and returns the array.
     * @param input
     * @return
     */
    public static int[] getArray(Scanner input) {

        //
        int size = getSize(input);
        
        // create an array that counts up to size
        int[] array = new int[size];

        //fill up the array
        for (int i = 1; i <= size; i++) {

            int pos = i - 1;

            // fill up with incremented numbers (starting at 1):
            //array[pos] = i;

            // fill up with random numbers (between 1 and 100):
            array[pos] = (int)(1 + Math.random() * 100);
        }

        return array;
    }
    /**
     * Question 1
     * @param input
     * @return
     */
    public static int getSize(Scanner input) {

            // prompt user
            System.out.print("Please enter an array size(positive integer): ");

            // read integer into size
            int size = input.nextInt();
        
            // check if size is valid
            if (!(size == (int)size) || size < 1)
                return getSize(input);

            return size;
    }
    /**
     * Question 2
     * Write a method named printArray that given an array of integers, prints the array
     * in a tabular format with 5 number in each line.
     * @param array
     */
    public static void printArray(int[] array) {

        int i = 0;

        while (i < array.length ) {
            
            // print formatted rows of 5
            System.out.printf("%-4s %-4s %-4s %-4s %-4s \n", 
                ((i < array.length) ? String.valueOf(array[i++]) : " "),
                ((i < array.length) ? String.valueOf(array[i++]) : " "),
                ((i < array.length) ? String.valueOf(array[i++]) : " "),
                ((i < array.length) ? String.valueOf(array[i++]) : " "),
                ((i < array.length) ? String.valueOf(array[i++]) : " "));
        }
    }
    /**
     * Question 3
     * Write a method named findMax that given an array of integers finds and returns the
     * maximum value in the array.
     * @param array
     * @return
     */
    public static int findMax(int[] array) {

        int largest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest)
                largest = array[i];
        }

        return largest;

    }

    /**
     * Question 4
     * Write a method named findMin that given an array of integers finds and returns the
     * minimum value in the array.
     * @param array
     * @return
     */
    public static int findMin(int[] array) {

        int smallest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest)
                smallest = array[i];
        }

        return smallest;
    }

    /**
     * Question 5
     * Write a method named findMaxIndex that given an array of integers finds and
     * returns the index of maximum value in the array.
     * @param array
     * @return
     */
    public static int findMaxIndex(int[] array) {

        int index = array[0], largest = findMax(array);

        for (int i = 0; i < array.length; i++) {
            
            if (array[i] == largest)
                index = i;
        }

        return index;

    }

    /**
     * Question 6
     * Write a method named findMinIndex that given an array of integers finds and
     * returns the index of minimum value in the array.
     * @param array
     * @return
     */
    public static int findMinIndex(int[] array) {

        int index = array[0], smallest = findMin(array);

        for (int i = 0; i < array.length; i++) {
            
            if (array[i] == smallest)
                index = i;
        }

        return index;

    }

    /**
     * Question 7
     * Write a method named isSortedAscend that given an array of integers, it checks
     * whether array is sorted in ascending order, and returns true or false correspondingly.
     * @param array
     * @return
     */
    public static Boolean isSortedAscend(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i > 0) 
                if (array[i] < array[i-1])
                    return false;
        }

        return true;
    }

    /**
     * Question 8
     * Write a method named isSortedDescend that given an array of integers, it checks
     * whether array is sorted in descending order, and returns true or false correspondingly.
     * @param array
     * @return
     */
    public static Boolean isSortedDescend(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i > 0) 
                if (array[i] > array[i-1])
                    return false;
        }

        return true;
    }
}