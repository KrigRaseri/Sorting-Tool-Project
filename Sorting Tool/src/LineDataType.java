import java.util.*;

class LineDataType  {

    public LineDataType(Scanner sc, String sortType) {
        switch (sortType) {
            case "natural":
                sortNaturally(sc);
                break;

            case "byCount":
                sortByCount(sc);
        }
    }

    public static void sortNaturally(Scanner sc) {
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        Collections.sort(lines);

        System.out.printf("Total lines: %s.\n", lines.size());
        System.out.println("Sorted data:");
        lines.forEach(line -> System.out.print(line + " "));
    }

    public static void sortByCount(Scanner sc) {
        TreeMap<String, Integer> freqCount = new TreeMap<>();
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }

        lines.forEach(word -> freqCount.put(word, Collections.frequency(lines, word)));
        Map<String, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        System.out.printf("Total words: %d.\n", lines.size());
        for (String val : sorted.keySet()) {
            timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / lines.size()));
            System.out.printf("%s: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
        }
    }
}