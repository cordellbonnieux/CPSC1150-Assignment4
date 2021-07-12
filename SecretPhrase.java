import java.util.*;
import java.lang.*;
public class SecretPhrase {
    public static void main(String[] args) {

        // make a phrase
        String secretPhrase = getPhrase();
        System.out.println("the secret phrase is: " + secretPhrase); // testing

        // make a hidden phrase version
        String phrase = scramblePhrase(secretPhrase, scrambleIndex(secretPhrase, spaces(secretPhrase)));
        System.out.println("the scrambled phrase is: " + phrase); // testing

        // triggers when phrase == secret phrase
        Boolean complete = false;

        // round counter
        int counter = 1;

        while (!complete) {

            if (secretPhrase.equals(phrase)) {

                complete = true;

            } else {
                
                // read a guess from the user
                char userGuess = guess(phrase, counter);

                // if guess is valid, update the phrase
                phrase = checkPhrase(phrase, secretPhrase, userGuess);

                // count the rounds
                counter++;  

            }
        }
        System.out.println("the secret phrase is: " + secretPhrase); // testing
        System.out.println("the scrambled phrase is: " + phrase); // testing
        System.out.println("number of rounds: " + counter); // testing

    }
    public static String getPhrase() {

        // placeholder phrase
        String phrase = "Hey there buddy";

        return phrase;
    }
    public static char guess(String phrase, int counter) {

        // prompt user
        System.out.print("Round #" + counter + ": Guess a letter to complete this sentence: '" + phrase + "' :");

        // scanner obj
        Scanner scan = new Scanner(System.in);

        // read a char
        char guess = scan.next().charAt(0);

        // make sure guess is not a number
        Boolean isDigit = Character.isDigit(guess);
        if (isDigit){
            System.out.println("Your guess was a number, please enter a letter.");
            return guess(phrase, counter);
        }

        // make sure the guess is not already revealed
        for (int i = 0; i < phrase.length() - 1; i++) {
            if (phrase.charAt(i) == guess) {

                System.out.println("That letter is already revealed, pick a new letter.");
                return guess(phrase, counter);
            }
        }

        return guess;
    }
    public static String scramblePhrase(String phrase, int[] scrambleIndex) {

        //hold the scrambled phrase
        String copy = "";

        // scramble the phrase
        for (int w = 0; w < phrase.length(); w++) {

            // assign asteriks'
            for (int v = 0; v < scrambleIndex.length; v++) {
                if (scrambleIndex[v] == w) {
                    copy += '*';
                    break;
                }      
            }

            if (copy.length() <= w)
                    copy += phrase.charAt(w);
        }

        return copy;
    }

    public static int[] spaces(String phrase) {

        // count the number of spaces and punctuation marks in the phrase
        int spaces = 0;
        for (int i = 0; i < phrase.length(); i++) {
        if (phrase.charAt(i) == ' ' || phrase.charAt(i) == ',' || phrase.charAt(i) == '.' || phrase.charAt(i) == '!')
            spaces++;
        }
        
        // create an array which indexes the spaces and punctuation
        int[] spaceArr = new int[spaces];
        
        // add the space and punctuation indexes to the array
        int x = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ' || phrase.charAt(i) == ',' || phrase.charAt(i) == '.' || phrase.charAt(i) == '!') {
                spaceArr[x] = i;
                x++;
            }
        }

        return spaceArr;
    }

    public static int[] scrambleIndex(String phrase, int[] spaceArr) {
    System.out.println("ENTERED scrambleIndex ----------"); // testing

        // create a scramble index list
        int[] scrambleIndex = new int[(((phrase.length() - spaceArr.length) / 2))];

    System.out.println("scrambleIndex array length = " + scrambleIndex.length); // testing

        // choose scramble indexes
        int i = 0;
        while (i < scrambleIndex.length) {
        
        System.out.println("ENTERED while loop " + i); // testing

            // select a random index
            int pos = (int)(Math.random() * (phrase.length() - 0)) + 0;

        System.out.println("random num pos = " + pos); // testing

            // check if the pos has any duplicate letters
            int duplicateCounter = 0;
            for (int y = 0; y < phrase.length(); y++) {
                if (phrase.charAt(y) == ' ' || phrase.charAt(y) == ',' || phrase.charAt(y) == '.' || phrase.charAt(y) == '!')
                    continue;
                else if (phrase.charAt(y) == phrase.charAt(pos) && y != pos)
                    duplicateCounter++;
            }

        System.out.println("letter @ pos = " + phrase.charAt(pos) + ", number of duplicates = " + duplicateCounter); // testing

            // if the number of duplicates exceed the free space left in the array, break.
            if ((scrambleIndex.length - (i + 1)) <= duplicateCounter) break;

            // find each duplicate and store in an array
            int[] duplicates = new int[duplicateCounter];
            int d = 0;
            for (int y = 0; y < phrase.length(); y++) {
                if (phrase.charAt(y) == ' ' || phrase.charAt(y) == ',' || phrase.charAt(y) == '.' || phrase.charAt(y) == '!')
                    continue;
                else if (phrase.charAt(y) == phrase.charAt(pos) && y != pos) {
                    duplicates[d] = y;
                    d++;
                System.out.println("position " + y + " of phrase stored in duplicates array (representing '" + phrase.charAt(y) + "')"); // testing
                }
            }

            // check if pos already exists
            Boolean valid = true;
            for (int y = 0; y < scrambleIndex.length; y++) {
                if (scrambleIndex[y] == pos)
                    valid = false;
            }

            // check if there is a space at that pos
            for (int y = 0; y < spaceArr.length; y++){
                if (spaceArr[y] == pos)
                    valid = false;
            }

            // add to scramble index list
            if (duplicateCounter > 0 && valid && (duplicates.length + 1) < (scrambleIndex.length - i)) {
                scrambleIndex[i] = pos;
                i++;
                for (int y = 0; y < duplicates.length; y++) {
                    scrambleIndex[i] = duplicates[y];
                    i++;
                System.out.println("index " + y + " added to final scramble list"); // testing
                }
            } else if (valid) {
                scrambleIndex[i] = pos;
                i++;
                System.out.println("index " + pos + " added to final scramble list"); // testing
            }
        }

        return scrambleIndex;
    }

    public static String checkPhrase(String phrase, String secretPhrase, char userGuess) {

        String copy = "";

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '*' && secretPhrase.charAt(i) == userGuess)
                copy += userGuess;
            else
                copy += phrase.charAt(i);
        }

        return copy;
    }

}