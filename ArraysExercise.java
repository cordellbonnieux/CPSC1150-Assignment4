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
        System.out.println("max is " + findMax(arr));

        // Question 4

        

    }
    /** 
     * Question 1 - getArray
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

            array[pos] = i;
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
     * @param array
     * @return
     */
    public static int findMax(int[] array) {

        int largest = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest)
                largest = array[i];
        }

        return largest;

    }
}