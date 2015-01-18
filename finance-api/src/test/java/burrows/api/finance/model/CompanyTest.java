package burrows.api.finance.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class CompanyTest {

    @Test
    public void testIntValue() {
        assertThat(Company.YAHOO.getIntValue(), is(0));
        assertThat(Company.GOOGLE.getIntValue(), is(1));
    }

    @Test
    public void testStringValue() {
        assertThat(Company.YAHOO.getStringValue(), is("YAHOO"));
        assertThat(Company.GOOGLE.getStringValue(), is("GOOGLE"));
    }

    @Test
    public void testFromInt() {
        assertThat(Company.fromInt(0), is(Company.YAHOO));
        assertThat(Company.fromInt(1), is(Company.GOOGLE));
    }

    @Test
    public void testFromString() {
        assertThat(Company.fromString("YAHOO"), is(Company.YAHOO));
        assertThat(Company.fromString("GOOGLE"), is(Company.GOOGLE));
    }

    //TODO Java 8
//    @Test
//    public void testFromString() {
//        assertThat(Company.fromString("YAHOO").get(), is(Company.YAHOO));
//        assertThat(Company.fromString("GOOGLE").get(), is(Company.GOOGLE));
//    }
//
//    @Test
//    public void testFromInt() {
//        assertThat(Company.fromInt(0).get(), is(Company.YAHOO));
//        assertThat(Company.fromInt(1).get(), is(Company.GOOGLE));
//    }
}
