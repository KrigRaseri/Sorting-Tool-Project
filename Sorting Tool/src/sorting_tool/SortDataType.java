package sorting_tool;

import java.util.*;

public interface SortDataType {
    void sortByCount(Scanner sc);
    void sortNaturally(Scanner sc);
}

class LongDataType implements SortDataType {
    public void sortNaturally(Scanner sc) {
        List<Long> numbers = new ArrayList<>();
        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }
        Collections.sort(numbers);

        System.out.printf("Total numbers: %d.\n", numbers.size());
        numbers.forEach(num -> System.out.print(num + " "));
    }

    public void sortByCount(Scanner sc) {
        List<Long> numbers = new ArrayList<>();
        TreeMap<Long, Integer> freqCount = new TreeMap<>();

        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }

        numbers.forEach(num -> freqCount.put(num, Collections.frequency(numbers, num)));
        Map<Long, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        System.out.printf("Total numbers: %d.\n", numbers.size());
        for (Long val : sorted.keySet()) {
            timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / numbers.size()));
            System.out.printf("%d: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
        }
    }
}

class LineDataType implements SortDataType {
    public void sortNaturally(Scanner sc) {
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        Collections.sort(lines);

        System.out.printf("Total lines: %s.\n", lines.size());
        System.out.println("Sorted data:");
        lines.forEach(line -> System.out.print(line + " "));
    }

    public void sortByCount(Scanner sc) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }

        lines.forEach(word -> freqCount.put(word, Collections.frequency(lines, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        System.out.printf("Total words: %d.\n", lines.size());
        for (String val : sorted.keySet()) {
            timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / lines.size()));
            System.out.printf("%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
        }
    }
}

class WordDataType implements SortDataType {

    public void sortNaturally(Scanner sc) {
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

    public void sortByCount(Scanner sc) {
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



