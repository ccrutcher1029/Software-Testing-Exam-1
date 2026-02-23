import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EnergyCalculatorTest {

    EnergyCalculator calc = new EnergyCalculator();

    @Test
    void testInvalidNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calculateRebate(-1, false, false));
    }

    @Test
    void testZeroUsage() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calculateRebate(0, false, false));
    }

    @Test
    void testTier1() {
        assertEquals(0.0, calc.calculateRebate(250, true, true));
        assertEquals(0.0, calc.calculateRebate(500, false, false));
    }

    @Test
    void testTier2SmartOnly() {
        assertEquals(0.10, calc.calculateRebate(600, true, false));
    }

    @Test
    void testTier2OptOutOnly() {
        assertEquals(0.10, calc.calculateRebate(600, false, true));
    }

    @Test
    void testTier2Both() {
        assertEquals(0.15, calc.calculateRebate(600, true, true));
    }

    @Test
    void testTier3Neither() {
        assertEquals(0.05, calc.calculateRebate(2000, false, false));
    }

    @Test
    void testTier3Both() {
        assertEquals(0.20, calc.calculateRebate(2000, true, true));
    }
}
