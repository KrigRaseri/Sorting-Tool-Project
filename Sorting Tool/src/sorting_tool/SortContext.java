package sorting_tool;

import java.io.File;
import java.util.Scanner;

public class SortContext {
    SortDataType sdt;

    /**
     * Handles strategy use, as well as method to use.
     *
     * @param sdt is the sortDataType to use.
     * @param sortType is the chosen sort type.
     * @param fileOutput file for output if present, if null data will be printed to console.
     * */
    public SortContext(Scanner sc, SortDataType sdt, String sortType, File fileOutput) {
        this.sdt = sdt;

        if (sortType.equals("natural")) {
            sdt.sortNatural(sc, fileOutput);
        } else {
            sdt.sortByCount(sc, fileOutput);
        }
    }
}
