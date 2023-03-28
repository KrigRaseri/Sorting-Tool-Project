import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongType {
    public static void longInfo(Scanner sc) {
        List<Long> numbers = new ArrayList<>();
        while (sc.hasNextLong()) {
            Long num = sc.nextLong();
            numbers.add(num);
        }

        long greatest = Collections.max(numbers);
        long times = Collections.frequency(numbers, greatest);
        long timesPercent = times / numbers.size();
        System.out.printf("Total numbers: %d.", numbers.size());
        System.out.printf("The greatest number: %d (%d time(s), %d).", greatest, times, timesPercent);
    }
}
