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
}
