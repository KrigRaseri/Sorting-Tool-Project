package sorting_tool;

import java.io.*;
import java.util.*;

public interface SortDataType {
    void sortByCount(Scanner sc, File outputFile);
    void sortNaturally(Scanner sc, File outputFile);
}

class LongDataType implements SortDataType {
    List<String> numbers = new ArrayList<>();

    public void sortNaturally(Scanner sc, File outputFile) {
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.matches("\\d+")) {
                Long num = Long.parseLong(word);
                numbers.add(num.toString());
            }
        }
        Collections.sort(numbers);

        FileHandler.naturalFileOutput("long", outputFile, numbers);
    }

    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.matches("\\d+")) {
                Long num = Long.parseLong(word);
                numbers.add(num.toString());
            }
        }
        Collections.sort(numbers);

        FileHandler.byCountFileOutput("long", outputFile, numbers, freqCount);
    }
}

class LineDataType implements SortDataType {
    List<String> lines = new ArrayList<>();

    public void sortNaturally(Scanner sc, File outputFile) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        lines.sort(Comparator.comparingInt(String::length));

        FileHandler.naturalFileOutput("lines", outputFile, lines);
    }

    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        lines.sort(Comparator.comparingInt(String::length));

        FileHandler.byCountFileOutput("line", outputFile, lines, freqCount);
    }
}

class WordDataType implements SortDataType {
    List<String> words = new ArrayList<>();

    public void sortNaturally(Scanner sc, File outputFile) {
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }
        Collections.sort(words);

        FileHandler.naturalFileOutput("words", outputFile, words);
    }

    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }

        FileHandler.byCountFileOutput("word", outputFile, words, freqCount);
    }
}



