import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by denis on 20.10.14.
 */
public class CalculateTest {
    @Test
    public void testCal() throws Exception{
        Calculation calculation = new Calculation();
        int n = calculation.cal(2,2);

        assertEquals(5,n);
    }
}
