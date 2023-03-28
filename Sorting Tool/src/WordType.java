import java.util.*;

public class WordType {
    public static void wordInfo(Scanner sc) {
        List<String> words = new ArrayList<>();

        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }

        String greatest = Collections.max(words, Comparator.comparing(String::length));
        long times = Collections.frequency(words, greatest);
        String timesPercent = String.valueOf((double) times / words.size());
        System.out.printf("Total words: %s.\n", words.size());
        System.out.printf("The longest word: %s (%d time(s), %s%%).", greatest, times, timesPercent.substring(2, 4));
    }
}
