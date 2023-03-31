package sorting_tool;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface Util {

    //Returns the appropriate commands from the CLI.
    static String[] getCommand(List<String> argsList) {
        String[] commands = new String[2];
        if (!checkDataType(argsList)) commands[0] = "long";
        if (!checkSortType(argsList)) commands[1] = "natural";

        if (checkDataType(argsList)) {
            int i = argsList.indexOf("-dataType");
            commands[0] = argsList.get(i + 1);
        }

        if (checkSortType(argsList)) {
            int i = argsList.indexOf("-sortingType");
            commands[1] = argsList.get(i + 1);
        }
        return commands;
    }

    //Checks for proper data type commands.
    private static boolean checkDataType(List<String> argsList) {
        if (argsList.contains("-dataType")) {
            if (argsList.contains("long") || (argsList.contains("word") || argsList.contains("line"))) {
                return true;
            }
            System.out.println("No data type defined!");
            return false;
        }
        return false;
    }

    //Checks for proper sorting type commands.
    private static boolean checkSortType(List<String> argsList) {
        if (argsList.contains("-sortingType")) {
            if (argsList.contains("natural") || (argsList.contains("byCount"))) {
                return true;

            } else {
                System.out.println("No sorting type defined!");
                return false;
            }
        }
        return false;
    }

    //Comparator to sort the frequency map to go by frequency, and then naturally.
    static <k, v extends Comparable<v> > Map<k, v> freqSortHelper(Map<k, v> map) {
        Comparator<k> valueComparator = (k1, k2) -> {
            int comp = map.get(k1).compareTo(map.get(k2));

            if (comp == 0) {
                return 1;
            } else {
                return comp;
            }
        };

        Map<k, v> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }
}

