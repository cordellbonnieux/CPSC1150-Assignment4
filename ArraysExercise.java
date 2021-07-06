import java.util.*;
/**
 * CPSC 1150 W01
 * Assignment 4 part 1
 * Intructor: Dr. Bita Shadgar
 * @author Cordell Bonnieux
 * @date 07/06/2021
 * Description: Various tasks involving arrays. 
 */
public class ArraysExercise {
    public static void main(String[] args) {

        // create scanner obj
        Scanner input = new Scanner(System.in);

        // Question 1
        int[] arr = getArray(input);

        // Question 2
        System.out.println("Here is your array...");
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

        // Question 9
        arr = swapNeighbor(arr);
        System.out.println("\n" + "Swap every neighbour in the array...");
        printArray(arr);

        // Question 10
        System.out.println("Take two sorted arrays and merge sort them...");

        // For this question I provided two fixed arrays, and the option to comment them out
        // in favour of using two randomly generated ones.

        int[] arr1 = {2, 4, 6, 8, 10, 12, 14, 16},
              arr2 = {3, 6, 9, 12, 15, 18, 21, 24};

        // generate 2 random arrays
        //int[] arr1 = getArray(input),
        //      arr2 = getArray(input);

        input.close();

        // the randomly generated arrays are very unlikely to pass this test.
        if (isSortedAscend(arr1) && isSortedAscend(arr2))
            printArray(merge(arr1, arr2));
        else
            System.out.println("Cannot merge unsorted arrays.");

    }
    /** 
     * Question 1
     * Write a method named getArray that asks user to input the array size n, then initializes
     * an array of n integers from user input and returns the array.
     * @param input
     * @return
     */
    public static int[] getArray(Scanner input) {

        // get size
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

        System.out.println();
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
    /**
     * Question 9
     * Write a method named swapNeighbor that given an array, it compares every two
     * neighbor numbers in the array (eg. A[i] and A[i+1]) and swaps them if A[i] is more than A[i+1].
     * It finally passes the new changes to the caller method. This method should be void method.
     * For example, for the given array {12, 9, 15, 7, 3}, as the result of calling swapNeighbor, the
     * array must be changed to {9, 12, 7, 3, 15}.
     * @param array
     */
    public static int[] swapNeighbor(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] > array[i+1]) {

                int temp = array[i];

                array[i] = array[i+1];

                array[i+1] = temp;
            } 
        }

        return array;
    }
    /**
     * Question 10
     * Write a method named merge that given two arrays sorted in ascending order, it
     * merges them into one sorted array in ascending order, and returns the merged array.
     * For example, if the given arrays are {2, 6, 9} and {-1, 5, 11, 12}, then the merged array must be
     * {-1, 2, 5, 6, 9, 11, 12}. If the given arrays are not sorted, then the merged array should not be
     * sorted either.
     * @param array1
     * @param array2
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        
            int[] merged = new int[a.length + b.length];
            int countA = 0, countB = 0, countM = 0;
        
        while (countA < a.length && countB < b.length) {

            if (a[countA] <= b[countB]) {

                merged[countM] = a[countA];
                countA++;

            } else {

                merged[countM] = b[countB];
                countB++;

            }

            countM++;
        }

        if (countA < a.length) {

            for (int x = countA; x < a.length; x++) {
                merged[countM] = a[x];
                countM++;
            }

        } else {

            for (int x = countB; x < b.length; x++) {
                merged[countM] = b[x];
                countM++;
            }
        }
 
        return merged;
    }
}