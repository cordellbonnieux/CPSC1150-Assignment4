import java.util.Scanner;
public static class ArraysExercise {
    public static void main(String[] args) {

        //
        Scanner input = new Scanner(System.in);

        // call question 1
        int[] arr = getArray(input);

        System.out.println(arr);


    }
    /**
     * Question 1
     * @param input
     * @return
     */
    public static int[] getArray(Scanner input) {

        // prompt user
        System.out.print("Please enter an array size(positive integer): ");

        // read integer into size
        int size = input.nextInt();

        // check if size is valid
        if (!(size == (int)size) || size < 1)
            return getArray(input);
        
        // create an array that counts up to size
        int[] sizeArray;

        //fill up the array
        for (int i = 1; i <= size; i++) {

            sizeArray[(i-1)] += i;
        }

        return sizeArray;
    }
}