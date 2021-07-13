import java.util.*;
import javax.swing.*;
import java.lang.*;
/**
 * CPSC 1150 W01
 * Assignment 4 part 2
 * Intructor: Dr. Bita Shadgar
 * @author Cordell Bonnieux
 * @date 07/12/2021
 * Description: A classic game of hangman; user guesses a letter and the game keeps score.
 */
public class SecretPhrase {
    public static void main(String[] args) {

        // make a phrase
        String secretPhrase = getPhrase();

        // make a hidden phrase version
        String phrase = scramblePhrase(secretPhrase, scrambleIndex(secretPhrase, spaces(secretPhrase)));

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

        // calculate and display user score
        int length = secretPhrase.length();
        double score = length / counter;
        JPanel summary = new JPanel();
        summary.setLayout(new BoxLayout(summary,BoxLayout.Y_AXIS));

        JLabel goodbye = new JLabel(String.format("Nice work, you found the secret phrase!"));
        JPanel goodbyeP = new JPanel();
        goodbyeP.add(goodbye); 
        summary.add(goodbyeP);

        JLabel secret = new JLabel(String.format(secretPhrase));
        JPanel secretP = new JPanel();
        secretP.add(secret);
        summary.add(secretP);

        JLabel results = new JLabel(String.format("Number of tries: %d; Length of phrase: %d; Score: %.2f", counter, length, score));
        JPanel resultsP = new JPanel();
        resultsP.add(results); 
        summary.add(resultsP);

        JOptionPane.showMessageDialog(null, summary);

        System.exit(0);
    }

    /**
     * Selects one of ten random Arnold Schwarzenegger quotes to be used in the game.
     * @return a random quote
     */
    public static String getPhrase() {

        int choice = (int)(Math.random() * (10 - 1)) + 1;

        // All phrases are quoted from Arnold Schwarzenegger (from various movies)

        // placeholder phrase
        String phrase = "Stick Around.";

        switch(choice) {
            case 1: phrase = "Consider that a divorce.";
                break;
            case 2: phrase = "Let off some steam, Bennett.";
                break;
            case 3: phrase = "I eat green berets for breakfast. And right now I'm very hungry.";
                break;
            case 4: phrase = "You’re Luggage.";
                break;
            case 5: phrase = "You Are Terminated.";
                break;
            case 6: phrase = "No Sequel For You.";
                break;
            case 7: phrase = "Hey, Claudius. You Killed My Father. Big Mistake.";
                break;
            case 8: phrase = "Freeze In Hell, Batman!";
                break;
            case 9: phrase = "Hey, Killian! Here Is Subzero! Now… Plain Zero!";
                break;
            case 10: phrase = "See You At The Party, Richter.";
                break;
        }

        return phrase;
    }

    /**
     * Reads a character from the user, ensures that it is valid (i.e. not a number) and that 
     * it is not an already revealed.
     * @param phrase the phrase to be deciphered
     * @param counter counts which guess number it is currently
     * @return the user's guess (a character)
     */
    public static char guess(String phrase, int counter) {

        // prompt user
        //System.out.print("Round #" + counter + ": Guess a letter to complete this sentence: '" + phrase + "' :");

        char guess = JOptionPane.showInputDialog(null, "Round #" + counter + ": Guess a letter to complete this sentence: '" + phrase).charAt(0);

        // scanner obj
        //Scanner scan = new Scanner(System.in);

        // read a char
        // char guess = scan.next().charAt(0);

        // make sure guess is not a number
        Boolean isDigit = Character.isDigit(guess);
        if (isDigit){
            //System.out.println("Your guess was a number, please enter a letter.");
            JOptionPane.showMessageDialog(null, "Your guess was a number, please enter a letter.");

            return guess(phrase, counter);
        }

        // make sure the guess is not already revealed
        for (int i = 0; i < phrase.length() - 1; i++) {
            if (phrase.charAt(i) == guess) {

                //System.out.println("That letter is already revealed, pick a new letter.");
                JOptionPane.showMessageDialog(null, "That letter is already revealed, pick a new letter.");

                return guess(phrase, counter);
            }
        }

        return guess;
    }

    /**
     * This program takes a phrase, and an array of indexs to scramble it with.
     * Then it iterates over the phrase, replacing each index point with an asterik.
     * @param phrase a phrase to be scrambled
     * @param scrambleIndex the indexes of the letters to be scrambled
     * @return a scrambled version of the phrase
     */
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

    /**
     * This method takes in a phrase and determines at what indexes it's
     * punctuation and spaces are at. It then returns and array of those indexes.
     * @param phrase the phrase to be examined
     * @return and array of indexes that represent the punctuation marks and spaces in the phrase
     */
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

    /**
     * This method determines which letters will be replaced with asteriks'.
     * @param phrase a phrase to do calculations on
     * @param spaceArr the indexes of the spaces and punctuation marks in the phrase
     * @return an array of indexes which represent which letters to replace with asteriks'
     */
    public static int[] scrambleIndex(String phrase, int[] spaceArr) {
        // create a scramble index list
        int[] scrambleIndex = new int[(((phrase.length() - spaceArr.length) / 2))];

        // choose scramble indexes
        int i = 0;
        while (i < scrambleIndex.length) {
        
            // select a random index
            int pos = (int)(Math.random() * (phrase.length() - 0)) + 0;

            // check if the pos has any duplicate letters
            int duplicateCounter = 0;
            for (int y = 0; y < phrase.length(); y++) {
                if (phrase.charAt(y) == ' ' || phrase.charAt(y) == ',' || phrase.charAt(y) == '.' || phrase.charAt(y) == '!')
                    continue;
                else if (Character.toLowerCase(phrase.charAt(y)) == Character.toLowerCase(phrase.charAt(pos)) && y != pos)
                    duplicateCounter++;
            }

            // if the number of duplicates exceed the free space left in the array, break.
            if ((scrambleIndex.length - (i + 1)) <= duplicateCounter) break;

            // find each duplicate and store in an array
            int[] duplicates = new int[duplicateCounter];
            int d = 0;
            for (int y = 0; y < phrase.length(); y++) {
                if (phrase.charAt(y) == ' ' || phrase.charAt(y) == ',' || phrase.charAt(y) == '.' || phrase.charAt(y) == '!')
                    continue;
                else if (Character.toLowerCase(phrase.charAt(y)) == Character.toLowerCase(phrase.charAt(pos)) && y != pos) {
                    duplicates[d] = y;
                    d++;
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
                }
            } else if (valid) {
                scrambleIndex[i] = pos;
                i++;
            }
        }

        return scrambleIndex;
    }

    /**
     * This method checks to see if the user guessed a correct letter.
     * @param phrase the phrase to be deciphered
     * @param secretPhrase the deciphered phrase
     * @param userGuess the user's guess (a character)
     * @return the updated phrase (if user guessed correctly, the same phrase if not)
     */
    public static String checkPhrase(String phrase, String secretPhrase, char userGuess) {

        String copy = "";

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '*' && Character.toLowerCase(secretPhrase.charAt(i)) == Character.toLowerCase(userGuess))
                copy += secretPhrase.charAt(i);
            else
                copy += phrase.charAt(i);
        }

        return copy;
    }

}