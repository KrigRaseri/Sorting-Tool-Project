package sorting_tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public interface FileHandler {

    //Checks for -inputFile and then grabs the path specified. Full path should be used for now.
    static Scanner getInputFile(List<String> argsList) {
        if (argsList.contains("-inputFile")) {
            String userFile = argsList.get(argsList.indexOf("-inputFile") + 1);
            File f = new File(userFile);
            try {
                return new Scanner(f);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return new Scanner(System.in);
        }
    }

    //Check for -outputFile and then grabs the name for the file in the FileSortOutput folder, creates it if !exist.
    static File getOutputFile(List<String> argsList) {
        if (argsList.contains("-outputFile")) {
            String userFile = argsList.get(argsList.indexOf("-outputFile") + 1);
            File f = new File("Sorting Tool/FileSortOutput/" + userFile);
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return f;
        }
        return null;
    }

    //Outputs the naturally sorted data to the output folder.
    static void naturalFileOutput(String type, File outputFile, List<String> list) {
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write(String.format("Total %s: %s", type , list.size()));

                switch (type) {
                    case "line" -> bw.write("\nSorted data:\n");
                    case "word", "long" -> bw.write("\nSorted data: ");
                }

                for (String s : list) {
                    if (type.equals("line")) {
                        bw.write(s + "\n");

                    } else {
                        bw.write(s + " ");
                    }
                }
                bw.write("\n");
                bw.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total %s: %s.\n", type, list.size());
            System.out.print("Sorted data: ");
            list.forEach(line -> System.out.print(line + " "));
        }
    }

    /**
     * Takes the sorted byCount text data and outputs it to the specified file, if outputFile is null then the output will
     * be printed out to the console.
     *
     * @param (list, map) contain the sorted data to be output.
     * */
    static void byCountFileOutput(String dataType, File outputFile, List<String> list, Map<String, Integer> map) {
        list.forEach(word -> map.put(word, Collections.frequency(list, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(map);

        int timesPercent;
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write(String.format("Total %s: %s", dataType, list.size()));
                for (String val : sorted.keySet()) {
                    timesPercent = (int) Math.round((map.get(val) * 100.0 / list.size()));
                    String output = String.format("\n%s: %d time(s), %s%%", val, map.get(val), timesPercent);
                    bw.write(output);
                }
                bw.write("\n");
                bw.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total words: %d.\n", list.size());
            for (String val : sorted.keySet()) {
                timesPercent = (int) Math.round((map.get(val) * 100.0 / list.size()));
                System.out.printf("%s: %d time(s), %s%%\n", val, map.get(val), timesPercent);
            }
        }
    }

    /**
     * Takes the sorted byCount whole number data and outputs it to the specified file, if outputFile is null then the output will
     * be printed out to the console.
     *
     * @param (list, map) contain the sorted data to be output.
     * */
    static void byCountFileOutputLong(String type, File outputFile, List<Long> list, Map<Long, Integer> map) {
        list.forEach(word -> map.put(word, Collections.frequency(list, word)));
        Map<Long, Integer> sorted = Util.freqSortHelper(map);

        int timesPercent;
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write(String.format("Total %s: %s", type, list.size()));
                for (Long val : sorted.keySet()) {
                    timesPercent = (int) Math.round((map.get(val) * 100.0 / list.size()));
                    String output = String.format("\n%s: %d time(s), %s%%", val, map.get(val), timesPercent);
                    bw.write(output);
                }
                bw.write("\n");
                bw.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total words: %d.\n", list.size());
            for (Long val : sorted.keySet()) {
                timesPercent = (int) Math.round((map.get(val) * 100.0 / list.size()));
                System.out.printf("%s: %d time(s), %s%%\n", val, map.get(val), timesPercent);
            }
        }
    }
}
