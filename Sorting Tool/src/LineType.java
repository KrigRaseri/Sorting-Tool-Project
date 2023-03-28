import java.util.*;

public class LineType {
    public static void lineInfo(Scanner sc) {
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }

        String greatest = Collections.max(lines, Comparator.comparing(String::length));
        long times = Collections.frequency(lines, greatest);
        String timesPercent = String.valueOf((double) times / lines.size());
        System.out.printf("Total lines: %s.\n", lines.size());
        System.out.println("The longest line:");
        System.out.println(greatest);
        System.out.printf("(%d time(s), %s%%).", times, timesPercent.substring(2, 4));
    }
}
