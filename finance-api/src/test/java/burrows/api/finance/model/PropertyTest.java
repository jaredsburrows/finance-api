package burrows.api.finance.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class PropertyTest {

    //TODO test all?
    @Test
    public void testIntValue() {
        assertThat(Property.AfterHoursChangeRealtime.getIntValue(), is(0));
        assertThat(Property.AnnualizedGain.getIntValue(), is(1));
    }

    @Test
    public void testStringValue() {
        assertThat(Property.AfterHoursChangeRealtime.getStringValue(), is("AfterHoursChangeRealtime"));
        assertThat(Property.AnnualizedGain.getStringValue(), is("AnnualizedGain"));
    }

    @Test
    public void testTagValue() {
        assertThat(Property.AfterHoursChangeRealtime.getTagValue(), is("c8"));
        assertThat(Property.AnnualizedGain.getTagValue(), is("g3"));
    }

    @Test
    public void testFromInt() {
        assertThat(Property.fromInt(0), is(Property.AfterHoursChangeRealtime));
        assertThat(Property.fromInt(1), is(Property.AnnualizedGain));
    }

    @Test
    public void testFromString() {
        assertThat(Property.fromString("AfterHoursChangeRealtime"), is(Property.AfterHoursChangeRealtime));
        assertThat(Property.fromString("AnnualizedGain"), is(Property.AnnualizedGain));
    }

    @Test
    public void testFromTag() {
        assertThat(Property.fromTag("c8"), is(Property.AfterHoursChangeRealtime));
        assertThat(Property.fromTag("g3"), is(Property.AnnualizedGain));
    }
}
