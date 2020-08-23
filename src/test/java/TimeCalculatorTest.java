import exception.NullEmptyException;
import exception.TimeFormatException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test class that tests the Add minute class functionality
 */
public class TimeCalculatorTest {

    private TimeCalculator timeCalculator;

    @Before
    public void setup() {
        timeCalculator = new TimeCalculator();
    }

    /* this test case covers a scenario where the input time string is null. we assert for NullEmpty Exception*/
    @Test(expected = NullEmptyException.class)
    public void testForNullTimeInput() throws NullEmptyException, TimeFormatException {
        timeCalculator.addMinutes(null, 200);
    }

    @Test(expected = NullEmptyException.class)
    public void testForEmptyTimeInput() throws NullEmptyException, TimeFormatException {
        timeCalculator.addMinutes("", 200);
    }

    @Test(expected = TimeFormatException.class)
    public void testForWrongTimeInput() throws NullEmptyException, TimeFormatException {
        timeCalculator.addMinutes("12:00", 200);
    }

    @Test
    public void testForZeroMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:47 AM", 0);
        Assert.assertEquals("11:47 AM", actualTime);
    }

    @Test
    public void testForPositiveMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 50);
        Assert.assertEquals("12:39 AM", actualTime);
    }

    @Test
    public void testForNegativeMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", -110);
        Assert.assertEquals("9:59 PM", actualTime);
    }

    @Test
    public void testForMinutesEqualToDayAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 1440);
        Assert.assertEquals("11:49 PM", actualTime);
    }

    @Test
    public void testForMinutesGreaterThanDayAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 1450);
        Assert.assertEquals("11:59 PM", actualTime);
    }

    @Test
    public void testForMinutesAddedThatChangeMeridianFromAMtoPM() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 AM", 1470);
        Assert.assertEquals("12:19 PM", actualTime);
    }


    @Test
    public void testForMinutesAddedThatChangeMeridianFromPMtoAM() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 30);
        Assert.assertEquals("12:19 AM", actualTime);
    }

    /* making the reference of the class to null so that gc can collect it as part of garbage collection*/
    @After
    public void destroy() {
        timeCalculator = null;
    }
}
