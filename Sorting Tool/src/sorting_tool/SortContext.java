package sorting_tool;

import java.io.File;
import java.util.Scanner;

public class SortContext {
    SortDataType sdt;

    public SortContext(Scanner sc, SortDataType sdt, String method, File fileOutput) {
        this.sdt = sdt;

        if (method.equals("natural")) {
            sdt.sortNaturally(sc, fileOutput);
        } else {
            sdt.sortByCount(sc, fileOutput);
        }
    }
}
