import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    /**
     * Problem number 3 on projecteuler.net:
     * What is the largest prime factor of the given number
     * @param valueToDivide
     * @return largest prime for given number, or -1, if there is no suitable number
     */
    public Long getLargestPrime(long valueToDivide) {
        if (valueToDivide < 1) throw new IllegalArgumentException("Prime numbers are greater than 1");

        long squareRootOfValue = (long)Math.ceil(Math.sqrt(valueToDivide)) +1;
        List<Long> primes = new ArrayList<>();
        for(long i = 2; i <= squareRootOfValue; i++) {
            if(valueToDivide % i == 0) {
                primes.add(i);
            }
        }

        for(Long prime: primes) {
            while(valueToDivide % prime == 0 && valueToDivide != 1) {
                valueToDivide = valueToDivide / prime;
            }
            if(valueToDivide == 1) {
                return prime;
            }
        }
        return -1L;
    }

    /**
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 � 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     * @return
     */
    public Integer getLargestNDigitPalindrome(int digitCount) {
        if(digitCount < 1) throw new IllegalArgumentException("Value must have at least one digit (in order to be a value))");
        char[] maxNDigitValueArray = new char[digitCount];
        Arrays.fill(maxNDigitValueArray, '9');
        int largestNDigitValue = createMaxValueWithNDigits(digitCount);
        int smallestNDigitValue = createMinValueWithNDigits(digitCount);
        List<Integer> palindromes = new ArrayList<>();
        for(int i = largestNDigitValue; i >= smallestNDigitValue; i--) {
            for(int j = largestNDigitValue; j >= smallestNDigitValue; j--) {
                int possiblePalindrome = i * j;
                if(isNumberPalindrome(possiblePalindrome)) {
                    palindromes.add(possiblePalindrome);
                }
            }
        }
        return palindromes.stream().mapToInt(i -> i).max().orElse(-1);
    }

    private int createMaxValueWithNDigits(int digitCount) {
        char[] maxNDigitValueArray = new char[digitCount];
        Arrays.fill(maxNDigitValueArray, '9');
        return Integer.valueOf(new String(maxNDigitValueArray));
    }

    private int createMinValueWithNDigits(int digitCount) {
        char[] minNDigitValueArray = new char[digitCount];
        Arrays.fill(minNDigitValueArray, '0');
        minNDigitValueArray[0] = '1';
        return Integer.valueOf(new String(minNDigitValueArray));
    }

    private boolean isNumberPalindrome(int number) {
        String numberAsString = String.valueOf(number);
        return numberAsString.equals(new StringBuilder(numberAsString).reverse().toString());
    }

    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     * @param largestDivisor
     * @return smallest divisable number
     * TODO: This is brute force answer, refactor it.
     */
    public Integer getSmallestNumberDivisibleByNumbersOneToN(int largestDivisor) {
        if(largestDivisor < 1) throw new IllegalArgumentException("Largest divisor must be at least 1");
        List<Integer> divisors = IntStream.range(1, largestDivisor + 1).boxed().collect(Collectors.toList());
        int divisableNumber = largestDivisor;
        while(divisableNumber != -1) {
            final int currentValue = divisableNumber;
            if(divisors.stream().allMatch(item -> currentValue % item == 0)) {
                return divisableNumber;
            }
            divisableNumber++;
        }
        return -1;
    }
}
