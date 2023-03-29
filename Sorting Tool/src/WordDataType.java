import java.util.*;

class WordDataType {

    public WordDataType(Scanner sc, String sortType) {
        switch (sortType) {
            case "natural":
                sortNaturally(sc);
                break;

            case "byCount":
                sortByCount(sc);
        }
    }

    public static void sortNaturally(Scanner sc) {
        List<String> words = new ArrayList<>();
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }
        Collections.sort(words);

        System.out.printf("Total words: %d.\n", words.size());
        System.out.print("Sorted data: ");
        words.forEach(word -> System.out.print(word + " "));
    }

    public static void sortByCount(Scanner sc) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        List<String> words = new ArrayList<>();

        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }

        words.forEach(word -> freqCount.put(word, Collections.frequency(words, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        System.out.printf("Total words: %d.\n", words.size());
        for (String val : sorted.keySet()) {
            timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / words.size()));
            System.out.printf("%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
        }
    }
}