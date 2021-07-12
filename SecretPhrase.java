import java.util.*;
public class SecretPhrase {
    public static void main(String[] args) {

        // make a phrase
        String secretPhrase = getPhrase();
        System.out.println("the secret phrase is: " + secretPhrase); // testing

        // make a hidden phrase version
        String phrase = scramblePhrase(secretPhrase);
        System.out.println("the scrambled phrase is: " + phrase); // testing

        // triggers when phrase == secret phrase
        Boolean complete = false;

        // round counter
        int counter = 1;

        while (!complete) {

            if (secretPhrase != phrase) {
                
                // read a guess from the user
                char userGuess = guess(phrase, counter);

                // if guess is valid, update the phrase
                phrase = checkPhrase(phrase, secretPhrase, userGuess);

                // count the rounds
                counter++;  

            } else
                complete = true;
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
        System.out.println("Round #" + counter + ": Guess a letter to complete this sentence: \n" + phrase);

        // scanner obj
        Scanner scan = new Scanner(System.in);

        // read a char
        char guess = scan.next().charAt(0);

        // make sure guess is not a number
        if (guess == (int)guess || guess == (double)guess){

            System.out.println("Your guess was a number, please enter a letter.");
            return guess(phrase, counter);
        }

        // make sure the guess is not already revealed
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == guess) {

                System.out.println("That letter is already revealed, pick a new letter.");
                return guess(phrase, counter);
            }
        }

        return guess;
    }
    public static String scramblePhrase(String phrase) {

        // get 2/3 the the length of string
        int asteriks = (phrase.length() / 3) * 2;

        String copy = "";

        while (asteriks > 0) {

            int pos = (int)(Math.random() * (phrase.length() - 0)) + 0;

            for (int i = 0; i < phrase.length(); i++) {

                if (i != pos)
                    copy += phrase.charAt(i);

                else {
                    copy += '*';
                    asteriks--;
                }

            }
        }
        return copy;
    }

    public static String checkPhrase(String phrase, String secretPhrase, char userGuess) {

        String copy = phrase;

        for (int i = 0; i < phrase.length(); i++) {
            if (copy.charAt(i) == '*' && secretPhrase.charAt(i) == userGuess)
                phrase += userGuess;
            else
                phrase += copy.charAt(i);
        }

        return phrase;
    }

}