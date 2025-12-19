import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            final int c3 = 1;
            final int c17 = 7;

            System.out.println("C3 = " + c3);
            System.out.println("C17 = " + c17);
            System.out.println();

            final String text =
                    "An eager owl observes unusual events in ancient cities. "
                            + "Every idea is unique, and each outcome is interesting! "
                            + "Is it easy to organize everything? "
                            + "Under old umbrellas, a user enjoys elegant art.";

            System.out.println("Original text:");
            System.out.println(text);
            System.out.println();

            List<String> allWords = extractWords(text);
            List<String> vowelStartingWords = new ArrayList<>();

            for (String word : allWords)
            {
                if (startsWithVowel(word))
                {
                    vowelStartingWords.add(word);
                }
            }

            vowelStartingWords.sort(
                    Comparator.comparingInt(Main::secondLetterKey)
                            .thenComparing(String::compareToIgnoreCase)
            );

            System.out.println("Words that start with a vowel, sorted by the second letter:");
            for (String word : vowelStartingWords)
            {
                System.out.println(word);
            }
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static List<String> extractWords(String text)
    {
        if (text == null)
        {
            throw new IllegalArgumentException("Text must not be null.");
        }

        String normalized = text.replaceAll("[^A-Za-z']", " ");

        String[] tokens = normalized.trim().split("\\s+");
        List<String> words = new ArrayList<>();

        for (String token : tokens)
        {
            String cleaned = token.trim();

            if (!cleaned.isEmpty())
            {
                words.add(cleaned);
            }
        }

        return words;
    }

    private static boolean startsWithVowel(String word)
    {
        if (word == null || word.isEmpty())
        {
            return false;
        }

        char first = Character.toLowerCase(word.charAt(0));
        return first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'y';
    }

    private static int secondLetterKey(String word)
    {
        if (word == null || word.length() < 2)
        {
            return Integer.MAX_VALUE;
        }

        return Character.toLowerCase(word.charAt(1));
    }
}
