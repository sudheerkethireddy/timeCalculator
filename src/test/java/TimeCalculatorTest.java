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

    /* this test case covers scenario where the input time string is empty string. we assert for NullEmpty Exception*/
    @Test(expected = NullEmptyException.class)
    public void testForEmptyTimeInput() throws NullEmptyException, TimeFormatException {
        timeCalculator.addMinutes("", 200);
    }

    /* this test case covers scenario where the input time string is in wrong format. we assert for TimeFormatException*/
    @Test(expected = TimeFormatException.class)
    public void testForWrongTimeInput() throws NullEmptyException, TimeFormatException {
        timeCalculator.addMinutes("12:00", 200);
    }

    /* this test case covers scenario where we  add 0 minutes to input time. we assert for resulting time to be same as input time*/
    @Test
    public void testForZeroMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:47 AM", 0);
        Assert.assertEquals("11:47 AM", actualTime);
    }

    /* this is a test case where we add positive minutes to the input and assert for the resulting time*/
    @Test
    public void testForPositiveMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("10:49 PM", 50);
        Assert.assertEquals("11:39 PM", actualTime);
    }

    /* this test case covers scenario where we subtract minutes to the input time and assert for expected time*/
    @Test
    public void testForNegativeMinutesAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", -110);
        Assert.assertEquals("9:59 PM", actualTime);
    }

    /* this test case covers scenario where we add 24 hours to input time and assert that resulting time to be same as input time*/
    @Test
    public void testForMinutesEqualToDayAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 1440);
        Assert.assertEquals("11:49 PM", actualTime);
    }

    /* this test case covers scenario where minutes added are 1 day and 10 minutes and we assert for resulting time */
    @Test
    public void testForMinutesGreaterThanDayAdded() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 1450);
        Assert.assertEquals("11:59 PM", actualTime);
    }

    /* this test covers sceanrio where when we add minutes to the input time it changes from AM to PM.*/
    @Test
    public void testForMinutesAddedThatChangeMeridianFromAMtoPM() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 AM", 1470);
        Assert.assertEquals("12:19 PM", actualTime);
    }

    /* this test covers sceanrio where when we add minutes to the input time it changes from PM to AM.*/
    @Test
    public void testForMinutesAddedThatChangeMeridianFromPMtoAM() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("11:49 PM", 30);
        Assert.assertEquals("12:19 AM", actualTime);
    }

    /* this test covers sceanrio where when we add minutes to the input time it changes from PM to AM.*/
    @Test
    public void testForMinutesAddedThatChangeHourButNotMeridian() throws NullEmptyException, TimeFormatException {
        String actualTime = timeCalculator.addMinutes("10:49 PM", 700);
        Assert.assertEquals("10:29 AM", actualTime);
    }

    /* making the reference of the class to null so that gc can collect it as part of garbage collection*/
    @After
    public void destroy() {
        timeCalculator = null;
    }
}
