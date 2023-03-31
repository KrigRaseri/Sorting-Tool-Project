package sorting_tool;

import java.io.*;
import java.util.*;

/**
 * Interface for strategy pattern, all are data types (long, word, line), and each has two methods sortNatural, or
 * sortByCount.
 * */
public interface SortDataType {
    void sortByCount(Scanner sc, File outputFile);
    void sortNatural(Scanner sc, File outputFile);
}

//Datatype for handling whole numbers
class LongDataType implements SortDataType {
    List<Long> numbers = new ArrayList<>();
    List<String> numbersString = new ArrayList<>();

    //Sorts all whole numbers from least to greatest.
    public void sortNatural(Scanner sc, File outputFile) {
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.matches("^(-)?(\\d+)")) {
                Long num = Long.parseLong(word);
                numbers.add(num);
            }
        }
        Collections.sort(numbers);
        numbers.forEach(num -> numbersString.add(num.toString()));

        FileHandler.naturalFileOutput("long", outputFile, numbersString);
    }

    //Sorts whole numbers by how frequent each number appears, then by least to greatest.
    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<Long, Integer> freqCount = new TreeMap<>();
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.matches("^(-)?(\\d+)")) {
                Long num = Long.parseLong(word);
                numbers.add(num);
            }
        }
        Collections.sort(numbers);

        FileHandler.byCountFileOutputLong("long", outputFile, numbers, freqCount);
    }
}

//Data type for whole lines of text.
class LineDataType implements SortDataType {
    List<String> lines = new ArrayList<>();

    //Sorts by shortest line to the longest line.
    public void sortNatural(Scanner sc, File outputFile) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        lines.sort(Comparator.comparingInt(String::length));

        FileHandler.naturalFileOutput("line", outputFile, lines);
    }

    //Sorts by the frequency of a line length appears, then by length.
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

//Data type for sorting words.
class WordDataType implements SortDataType {
    List<String> words = new ArrayList<>();

    //Sorts lexicographically.
    public void sortNatural(Scanner sc, File outputFile) {
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }
        Collections.sort(words);

        FileHandler.naturalFileOutput("word", outputFile, words);
    }

    //Sorts by frequency of a word, and then lexicographically.
    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }

        FileHandler.byCountFileOutput("word", outputFile, words, freqCount);
    }
}



