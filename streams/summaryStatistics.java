import java.util.IntSummaryStatistics;
import java.util.List;

public class summaryStatistics {
    List<Integer> list = List.of(5, 1, 9, 3, 7);
    // 🔥 1. Max value
    int max = list.stream()
            .max(Integer::compareTo)
            .orElse(0);

    // ✔ Output: 9

    // 🔥 2. Min value
    int min = list.stream()
            .min(Integer::compareTo)
            .orElse(0);

    // ✔ Output: 1

    // 🔥 3. Sum of all numbers
    int sum = list.stream()
            .mapToInt(Integer::intValue)
            .sum();

    // ✔ Output: 25

    // 🔥 4. Average of all numbers
    double avg = list.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);

    // ✔ Output: 5.0

    // ⚡ Better (cleaner) approach for max/min
    IntSummaryStatistics stats = list.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();

    // 🔹 Get everything
    int maxs = stats.getMax();
    int mins = stats.getMin();
    long sums = stats.getSum();
    double avgs = stats.getAverage();
    long count = stats.getCount();
}
