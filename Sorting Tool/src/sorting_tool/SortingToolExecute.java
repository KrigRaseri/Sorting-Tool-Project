package sorting_tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortingToolExecute {

    /**
     * Makes a list from args and then checks the datatype and sort type and returns the appropriate command for use.
     * If an outputFile is present in the args a file scanner will be used and the data will be output to the specified
     * file, if null then a Scanner(System.in) will be made and the data will be output to the console.
     * */
    public static void sortingToolExecute(String[] args) {
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        String[] command = Util.getCommand(argsList);
        String dataType = command[0];
        String sortingType = command[1];
        Scanner sc = FileHandler.getInputFile(argsList);
        File outputFile = FileHandler.getOutputFile(argsList);

        switch (dataType) {
            case "long" -> new SortContext(sc, new LongDataType(), sortingType, outputFile);
            case "word" -> new SortContext(sc, new WordDataType(), sortingType, outputFile);
            case "line" -> new SortContext(sc, new LineDataType(), sortingType, outputFile);
        }
        sc.close();
    }
}
