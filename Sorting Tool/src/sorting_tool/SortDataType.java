package sorting_tool;

import java.io.*;
import java.util.*;

public interface SortDataType {
    void sortByCount(Scanner sc, File outputFile);
    void sortNaturally(Scanner sc, File outputFile);
}

class LongDataType implements SortDataType {
    public void sortNaturally(Scanner sc, File outputFile) {
        List<Long> numbers = new ArrayList<>();
        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }
        Collections.sort(numbers);

        System.out.printf("Total numbers: %d.\n", numbers.size());
        numbers.forEach(num -> System.out.print(num + " "));

        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
                List<String> forOutput = new ArrayList<>();
                numbers.forEach(num -> forOutput.add(num.toString()));

                bw.write("Total numbers: " + numbers.size());
                bw.write("\nSorted data: ");

                for (String s : forOutput) {
                    bw.write(s + " ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total numbers: %d.\n", numbers.size());
            numbers.forEach(num -> System.out.print(num + " "));
        }
    }

    public void sortByCount(Scanner sc, File outputFile) {
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
    public void sortNaturally(Scanner sc, File outputFile) {
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        Collections.sort(lines);

        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
                List<String> forOutput = new ArrayList<>(lines);

                bw.write("Total numbers: " + lines.size());
                bw.write("\nSorted data: ");

                for (String s : forOutput) {
                    bw.write(s + " ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total lines: %s.\n", lines.size());
            System.out.println("Sorted data:");
            lines.forEach(line -> System.out.print(line + " "));
        }
    }

    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }

        lines.forEach(word -> freqCount.put(word, Collections.frequency(lines, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;

        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write("Total lines: " + lines.size());

                for (String val : sorted.keySet()) {
                    timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / lines.size()));
                    String output = String.format("\n%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
                    bw.write(output);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total lines: %d.\n", lines.size());
            for (String val : sorted.keySet()) {
                timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / lines.size()));
                System.out.printf("%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
            }
        }
    }
}

class WordDataType implements SortDataType {

    public void sortNaturally(Scanner sc, File outputFile) {
        List<String> words = new ArrayList<>();
        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }
        Collections.sort(words);

        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
                List<String> forOutput = new ArrayList<>(words);

                bw.write("Total numbers: " + words.size());
                bw.write("\nSorted data: ");

                for (String s : forOutput) {
                    bw.write(s + " ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total words: %d.\n", words.size());
            System.out.print("Sorted data: ");
            words.forEach(word -> System.out.print(word + " "));
        }
    }

    public void sortByCount(Scanner sc, File outputFile) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        List<String> words = new ArrayList<>();

        while (sc.hasNext()) {
            String w = sc.next();
            words.add(w);
        }

        words.forEach(word -> freqCount.put(word, Collections.frequency(words, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write("Total words: " + words.size());
                for (String val : sorted.keySet()) {
                    timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / words.size()));
                    String output = String.format("\n%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
                    bw.write(output);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total words: %d.\n", words.size());
            for (String val : sorted.keySet()) {
                timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / words.size()));
                System.out.printf("%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
            }
        }
    }
}



