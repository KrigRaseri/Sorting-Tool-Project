import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public interface Util {

    static <k, v extends Comparable<v> > Map<k, v> freqSortHelper(Map<k, v> map) {

        Comparator<k> valueComparator = new Comparator<k>() {
            public int compare(k k1, k k2) {
                int comp = map.get(k1).compareTo(map.get(k2));

                if (comp == 0)
                    return 1;

                else
                    return comp;
            }
        };

        Map<k, v> sorted = new TreeMap<>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}
