import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimePeriodTest {

    private TimePeriod dateA;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYYY");

    @Before
    public void setUp() throws ParseException {

        dateA = new TimePeriod(simpleDateFormat.parse("01/01/2018"), simpleDateFormat.parse("04/01/2018"));
    }

    // testAcontainsB()
    @Test
    public void testAcontainsB() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("02/01/2018"), simpleDateFormat.parse("03/01/2018"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    // testBcontainsA()
    @Test
    public void testBcontainsA() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("02/01/2017"), simpleDateFormat.parse("03/01/2019"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    // testBinteractA()
    @Test
    public void testBinteractA() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("02/01/2018"), simpleDateFormat.parse("03/01/2019"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    // testAinteractB()
    @Test
    public void testAinteractB() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("02/01/2018"), simpleDateFormat.parse("03/01/2019"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    // testAequalsB()
    @Test
    public void testAequalsB() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("01/01/2018"), simpleDateFormat.parse("04/01/2018"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    // testAendEqualToBstart()
    @Test
    public void testAendEqualToBstart() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("06/01/2018"), simpleDateFormat.parse("04/01/2018"));
        Assert.assertTrue(dateA.overlapsWith(dateB));
    }

    @Test
    public void testFalse() throws ParseException {
        TimePeriod dateB = new TimePeriod(simpleDateFormat.parse("06/01/2019"), simpleDateFormat.parse("04/01/2020"));
        Assert.assertFalse(dateA.overlapsWith(dateB));
    }
}
