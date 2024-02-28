import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String regex = "\\b((?:https?|ftp|file):"
                + "\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*"
                + "[-a-zA-Z0-9+&@#\\/%=~_|])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "^\\S+@\\S+\\.\\S+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt((i));
            if (c == ' ' || c == ':' || i == input.length() - 1) {
                if (c != ' ' && c != ':')
                    word += c;
                words.add(word);
                word = "";
                continue;
            }
            word += c;
        }

        boolean willBreak;
        for (String s : words) {
            willBreak = false;
            char[] characters = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (characters[i] == characters[j]) {
                        wordsWithRepeatLetters.add(s);
                        willBreak = true;
                        break;
                    }
                }
                if (willBreak)
                    break;
            }
        }
        return wordsWithRepeatLetters;
    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String input) {
        List<String> repeatedWords = new ArrayList<>();
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt((i));
            if (c == ' ' || c == ':' || i == input.length() - 1) {
                if (c != ' ' && c != ':')
                    word += c;
                words.add(word);
                word = "";
                continue;
            }
            word += c;
        }

        boolean willBreak;
        for (String s : words) {
            willBreak = false;
            char[] characters = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (characters[i] == characters[j]) {
                        wordsWithRepeatLetters.add(s);
                        willBreak = true;
                        break;
                    }
                }
                if (willBreak)
                    break;
            }
        }

        for (String s : wordsWithRepeatLetters) {
            if (s.length() % 2 == 0) {
                String firstPart = s.substring(0, (s.length() / 2)),
                        secondPart = s.substring((s.length() / 2));
                if (firstPart.equals(secondPart))
                    repeatedWords.add(s);
            }
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}