import java.util.ArrayList;
import java.util.List;
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

    /**
     * Problem number 2 on projecteuler.net:
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     * @param largestFibonacciNumberAllowed
     * @return the sum of even fibonacci numbers in series which maximum number is largestFibonacciNumberAllowed
     */
    public Integer getTotalSumForEvenFibonacciNumbers(int largestFibonacciNumberAllowed) {
        if (largestFibonacciNumberAllowed < 0) throw new IllegalArgumentException("Series' maximum allowed value must be positive value");
        List<Long> fiboValues = new ArrayList<>();
        Stream.iterate(
            new long[]{1, 1},
            f -> new long[]{f[1], f[0] + f[1]}
        ).mapToLong(ele -> ele[0]).peek(fibValue -> { if(fibValue <= largestFibonacciNumberAllowed) fiboValues.add(fibValue); }).allMatch(fibValue -> fibValue <= largestFibonacciNumberAllowed);
        return fiboValues.stream()
                .filter(ele -> ele % 2 == 0)
                .mapToInt(i -> Long.valueOf(i).intValue()).sum();

    }
}
