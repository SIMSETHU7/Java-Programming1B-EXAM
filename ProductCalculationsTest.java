package productapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
            new ProductCalculations(3500);

        double expectedVAT = 525.0;

        double actualVAT = product.GetVat();

        assertEquals(expectedVAT, actualVAT, 0.001);

    }
}
