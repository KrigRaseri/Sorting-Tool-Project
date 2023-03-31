package sorting_tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public interface FileHandler {

    static Scanner getInputFile(List<String> argsList) {
        if (argsList.contains("-inputFile")) {
            String userFile = argsList.get(argsList.indexOf("-inputFile") + 1);
            File f = new File("C:\\Users\\Krig\\Documents\\GitHub\\Sorting-Tool-Project\\Sorting Tool\\" + userFile);
            try {
                return new Scanner(f);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return new Scanner(System.in);
        }
    }

    static File getOutputFile(List<String> argsList) {
        if (argsList.contains("-outputFile")) {
            String userFile = argsList.get(argsList.indexOf("-outputFile") + 1);
            File f = new File("C:\\Users\\Krig\\Documents\\GitHub\\Sorting-Tool-Project\\Sorting Tool\\" + userFile);
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

    static void naturalFileOutput(String type, File outputFile, List<String> list) {
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write(String.format("Total %s: %s", type , list.size()));

                bw.write("\nSorted data: ");
                for (String s : list) {
                    if (type.equals("lines")) {
                        bw.write(s + "\n");
                    } else {
                        bw.write(s + " ");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.printf("Total %s: %s.\n", type, list.size());
            System.out.println("Sorted data:");
            list.forEach(line -> System.out.print(line + " "));
        }
    }

    static void byCountFileOutput(String type, File outputFile, List<String> list, Map<String, Integer> map) {
        list.forEach(word -> map.put(word, Collections.frequency(list, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(map);

        int timesPercent;
        if (outputFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write(String.format("Total %s: %s", type, list.size()));
                for (String val : sorted.keySet()) {
                    timesPercent = (int) Math.round((map.get(val) * 100.0 / list.size()));
                    String output = String.format("\n%s: %d time(s), %s%%", val, map.get(val), timesPercent);
                    bw.write(output);
                }
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
}
