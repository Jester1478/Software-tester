import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    GradeCalculator gc = new GradeCalculator();

    // EP: TC2-TC9
    @ParameterizedTest
    @CsvSource({
        "25, F",
        "52, D",
        "57, D+",
        "62, C",
        "67, C+",
        "72, B",
        "77, B+",
        "90, A"
    })
    void testEP(int score, String expected) {
        assertEquals(expected, gc.calculateGrade(score));
    }

    // EP Invalid: TC1, TC10
    @ParameterizedTest
    @ValueSource(ints = {-10, 150})
    void testEPInvalid(int score) {
        assertThrows(IllegalArgumentException.class,
                () -> gc.calculateGrade(score));
    }

    // BVA: TC12-TC36
    @ParameterizedTest
    @CsvSource({
        "0, F", "1, F", "49, F",
        "50, D", "51, D", "54, D",
        "55, D+", "56, D+", "59, D+",
        "60, C", "61, C", "64, C",
        "65, C+", "66, C+", "69, C+",
        "70, B", "71, B", "74, B",
        "75, B+", "76, B+", "79, B+",
        "80, A", "81, A", "99, A", "100, A"
    })
    void testBVA(int score, String expected) {
        assertEquals(expected, gc.calculateGrade(score));
    }

    // BVA Invalid: TC11, TC37
    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void testBVAInvalid(int score) {
        assertThrows(IllegalArgumentException.class,
                () -> gc.calculateGrade(score));
    }
}