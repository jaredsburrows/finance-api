package burrows.api.finance.model;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class RequestURLDataTest {

    @Test
    public void testGetSetCompany() {
        RequestURLData requestURLData = new RequestURLData().setCompany(Company.GOOGLE);

        assertThat(requestURLData.getCompany(), is(Company.GOOGLE));

        requestURLData.setCompany(Company.YAHOO);

        assertThat(requestURLData.getCompany(), is(Company.YAHOO));
    }

    @Test
    public void testGetSetFormat() {
        RequestURLData requestURLData = new RequestURLData().setFormat(Format.JSON);

        assertThat(requestURLData.getFormat(), is(Format.JSON));

        requestURLData.setFormat(Format.XML);

        assertThat(requestURLData.getFormat(), is(Format.XML));
    }

    @Test
    public void testGetAddQuote() {
        RequestURLData requestURLData = new RequestURLData().addQuote("GOOG");
        Set<String> quotes = new HashSet<>();
        quotes.add("GOOG");

        assertThat(requestURLData.getQuotes(), is(quotes));

        requestURLData.addQuote("YHOO");
        quotes.add("YHOO");

        assertThat(requestURLData.getQuotes(), is(quotes));
    }

    @Test
    public void testGetAddQuotes() {
        RequestURLData requestURLData = new RequestURLData().addQuote("GOOG").addQuote("YHOO");
        Set<String> quotes = new HashSet<>();
        quotes.add("GOOG");
        quotes.add("YHOO");

        assertThat(requestURLData.getQuotes(), is(quotes));

        RequestURLData requestURLData2 = new RequestURLData().addQuotes(quotes);

        assertThat(requestURLData2.getQuotes(), is(quotes));
    }
}
