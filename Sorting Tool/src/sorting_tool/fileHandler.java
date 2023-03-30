package sorting_tool;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
}
