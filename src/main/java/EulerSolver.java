import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Simo on 3.12.2015.
 */
public class EulerSolver {


    /**
     * Problem number 1 on projecteuler.net:
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     * @param rangeUpperBound
     * @param divisors
     * @return
     */
    public Integer getTotalSumFromDivisableElements(Integer rangeUpperBound, Integer... divisors) {
        if (rangeUpperBound == null || divisors == null) throw new IllegalArgumentException("Both range's upper limit and divisor list are required when calculating sum of passing elements");
        Stream<Integer> elementsToUpperBound = Stream.iterate(0, (i) -> ++i).limit(rangeUpperBound);
        return elementsToUpperBound
                .filter(divisableNumber -> Stream.of(divisors).anyMatch(divisor -> divisableNumber % divisor == 0))
                .mapToInt(i -> i)
                .sum();
    }
}
