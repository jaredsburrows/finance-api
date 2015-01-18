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
public class RequestURLSerializerTest {

    private final static String YAHOO_FINANCE_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";

    @Test
    public void testYahooJSONQuote() {
        RequestURLData requestURLData = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.DEFAULT)
                .addQuote("YHOO")
                .build();

        RequestURLSerializer requestURLSerializer = new RequestURLSerializer(requestURLData);

        assertThat(requestURLSerializer.getURL(), is(YAHOO_FINANCE_BASE_URL + "YHOO"));
    }

    @Test
    public void testYahooJSONQuotes() {
        Set<String> quotes = new LinkedHashSet<>();
        quotes.add("YHOO");
        quotes.add("GOOG");

        RequestURLData requestURLData = RequestURL.Builder()
                .withCompany(Company.YAHOO)
                .withFormat(Format.DEFAULT)
                .addQuotes(quotes)
                .build();

        RequestURLSerializer requestURLSerializer = new RequestURLSerializer(requestURLData);

        assertThat(requestURLSerializer.getURL(), is(YAHOO_FINANCE_BASE_URL + "YHOO,GOOG"));
    }
}
