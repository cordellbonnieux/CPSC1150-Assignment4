import java.util.*;
public class ArraysExercise {
    public static void main(String[] args) {

        // create scanner obj
        Scanner input = new Scanner(System.in);

        // call question 1
        int[] arr = getArray(input);
        System.out.println("ok!");

        

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
}