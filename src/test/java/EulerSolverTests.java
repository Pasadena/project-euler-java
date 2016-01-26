import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Simo on 3.12.2015.
 */
public class EulerSolverTests {

    @Test
    public void naturalNumbersDivisibleByThreeAndFiveUnderTenSumsTo23() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getTotalSumFromDivisableElements(10, 5, 3);
        assertEquals("Sum of elements that are under 10 and divisable by 3 or 5 is 23", Integer.valueOf(23), result);
    }

    @Test
    public void naturalNumbersDivisibleByThreeAndSevenUnderTenSumsTo25() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getTotalSumFromDivisableElements(10, 7, 3);
        assertEquals("Sum of elements that are under 10 and divisable by 3 or 7 is 25", Integer.valueOf(25), result);
    }

    @Test
    public void naturalNumbersDivisibleByThreeAndSevenUnderThousandSumsTo233168() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getTotalSumFromDivisableElements(1000, 5, 3);
        assertEquals("Sum of elements that are under 1000 and divisable by 3 or 5 is 233168", Integer.valueOf(233168), result);
    }

    @Test
    public void evenFibonacciNumbersWithTresholdOfTenSumsToTen() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getTotalSumForEvenFibonacciNumbers(10);
        assertEquals("Sum of even fibonacci number under 10 is ", Integer.valueOf(10), result);
    }

    @Test
    public void evenFibonacciNumbersWithTresholdOfFourMillionSumsTo4613732() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getTotalSumForEvenFibonacciNumbers(4000000);
        assertEquals("Sum of even fibonacci number under 4000000 is ", Integer.valueOf(4613732), result);
    }

    @Test
    public void largestPrimeForNumber13195Is29() {
        EulerSolver eulerSolver = new EulerSolver();
        Long result = eulerSolver.getLargestPrime(13195);
        assertEquals("The largest prime for number 13195 is ", Long.valueOf(29L), result);
    }

    @Test
    public void largestPrimeForNumber600851475143s6857() {
        EulerSolver eulerSolver = new EulerSolver();
        Long result = eulerSolver.getLargestPrime(600851475143L);
        assertEquals("The largest prime for number 600851475143 is ", Long.valueOf(6857L), result);
    }

    @Test
    public void largestPalindromeMadeFromTwoNumbersWithLengthOfTwoIs9009() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getLargestNDigitPalindrome(2);
        assertEquals("The largest palindrome made from the product of two 2-digit numbers is 9009 ", Integer.valueOf(9009), result);
    }

    @Test
    public void largestPalindromeMadeFromTwoNumbersWithLengthOfThreeIs906609() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getLargestNDigitPalindrome(3);
        assertEquals("The largest palindrome made from the product of two 3-digit numbers is 906609 ", Integer.valueOf(906609), result);
    }

    @Test
    public void smallestDivisableNumberWithValuesFromOneToTenIs2520() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getSmallestNumberDivisibleByNumbersOneToN(10);
        assertEquals("The smallest number divisable with values from 1 to 10 without remainder is 2520 ", Integer.valueOf(2520), result);
    }

    @Test
    public void smallestDivisableNumberWithValuesFromOneToTwentyIs232792560() {
        EulerSolver eulerSolver = new EulerSolver();
        Integer result = eulerSolver.getSmallestNumberDivisibleByNumbersOneToN(20);
        assertEquals("The smallest number divisable with values from 1 to 20 without remainder is 232792560 ", Integer.valueOf(232792560), result);
    }
}
