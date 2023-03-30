package sorting_tool;

import java.util.Scanner;

public class SortContext {
    SortDataType sdt;

    public SortContext(Scanner sc, SortDataType sdt, String method) {
        this.sdt = sdt;

        if (method.equals("natural")) {
            sdt.sortNaturally(sc);
        } else {
            sdt.sortByCount(sc);
        }
    }
}
