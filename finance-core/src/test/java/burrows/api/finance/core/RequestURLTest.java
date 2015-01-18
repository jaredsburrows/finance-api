package burrows.api.finance.core;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import burrows.api.finance.model.Company;
import burrows.api.finance.model.Format;
import burrows.api.finance.model.RequestURLData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class RequestURLTest {

    private final static String YAHOO_FINANCE_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";

    @Test
    public void testYahooJSONQuote() {
        Set<String> quotes = new LinkedHashSet<>();
        quotes.add("YHOO");

        RequestURLData requestURLData = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.JSON)
                .addQuote("YHOO")
                .build();

        assertThat(requestURLData.getCompany(), is(Company.YAHOO));
        assertThat(requestURLData.getFormat(), is(Format.JSON));
        assertThat(requestURLData.getQuotes(), is(quotes));
    }

    @Test
    public void testYahooJSONQuotes() {
        Set<String> quotes = new LinkedHashSet<>();
        quotes.add("YHOO");
        quotes.add("GOOG");

        RequestURLData requestURLData = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.JSON)
                .addQuotes(quotes)
                .build();

        assertThat(requestURLData.getCompany(), is(Company.YAHOO));
        assertThat(requestURLData.getFormat(), is(Format.JSON));
        assertThat(requestURLData.getQuotes(), is(quotes));
    }

    @Test
    public void testYahooDefaultQuoteURL() {
        String requestURL = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.DEFAULT)
                .addQuote("YHOO")
                .buildURL();

        assertThat(requestURL, is(YAHOO_FINANCE_BASE_URL + "YHOO"));
    }

    @Test
    public void testYahooDefaultQuotesURL() {
        Set<String> quotes = new LinkedHashSet<>();
        quotes.add("YHOO");
        quotes.add("GOOG");

        String requestURL = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.DEFAULT)
                .addQuotes(quotes)
                .buildURL();

        assertThat(requestURL, is(YAHOO_FINANCE_BASE_URL + "YHOO,GOOG"));
    }
}
