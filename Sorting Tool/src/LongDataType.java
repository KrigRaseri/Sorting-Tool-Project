import java.util.*;

public class LongDataType {

    public LongDataType(String sortType, Scanner sc) {
        switch (sortType) {
            case "natural":
                sortNaturally(sc);
                break;

            case "byCount":
                sortByCount(sc);
        }
    }

    public static void sortNaturally(Scanner sc) {
        List<Long> numbers = new ArrayList<>();
        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }
        Collections.sort(numbers);

        System.out.printf("Total numbers: %d.\n", numbers.size());
        numbers.forEach(num -> System.out.print(num + " "));
    }

    public static void sortByCount(Scanner sc) {
        List<Long> numbers = new ArrayList<>();
        TreeMap<Long, Integer> freqCount = new TreeMap<>();

        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }

        numbers.forEach(num -> freqCount.put(num, Collections.frequency(numbers, num)));
        Map<Long, Integer> sorted = Util.freqSortHelper(freqCount);

        int timesPercent;
        System.out.printf("Total numbers: %d.\n", numbers.size());
        for (Long val : sorted.keySet()) {
            timesPercent = (int) Math.round((freqCount.get(val) * 100.0 / numbers.size()));
            System.out.printf("%d: %d time(s), %s%%\n", val, freqCount.get(val), timesPercent);
        }
    }
}