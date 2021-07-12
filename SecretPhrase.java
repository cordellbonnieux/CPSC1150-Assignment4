import java.util.*;
public class SecretPhrase {
    public static void main(String[] args) {

        // make a phrase
        String secretPhrase = getPhrase();

        // make a hidden phrase version
        String phrase = scramblePhrase(secretPhrase);

        // triggers when phrase == secret phrase
        Boolean complete = false;

        // round counter
        int counter = 1;

        while (!complete) {

            if (secretPhrase != phrase) {

            } else
                complete = true;

        }

    }
    public static String getPhrase() {

        // placeholder phrase
        String phrase = "Hey there buddy";

        return phrase;
    }
    public static char guess() {

        // scanner obj
        Scanner scan = new Scanner(System.in);

        // read a char
        char guess = scan.next().charAt(0);

        // make sure guess is not an integer
        if (guess == (int)guess || guess == (double)guess)
            return guess();

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

}