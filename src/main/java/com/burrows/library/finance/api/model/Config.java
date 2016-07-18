package com.burrows.library.finance.api.model;

import com.burrows.library.finance.api.model.yahoo.Property;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Request URL Data for creating HTTP requests.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @see Property
 * @since 0.0.1
 */
public class Config {

    private final static String YAHOO_FINANCE_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?";
    private final static String YAHOO_FINANCE_STOCKS = "s=";
    private final static String YAHOO_FINANCE_PROPERTIES = "&f=";
    private final static String YAHOO_FINANCE_OUTPUT_CSV = "&e=.csv";

    private Set<String> properties = new LinkedHashSet<>();
    private Set<String> quotes = new LinkedHashSet<>();
    private Service service = Service.YAHOO;
    private Output output = Output.CSV;

    public enum Output {
        CSV,
        JSON,
        XML
    }

    public enum Service {
        GOOGLE,
        YAHOO
    }

    public Output getOutput() {
        return this.output;
    }

    public Config setOutput(final Output output) {
        this.output = output;
        return this;
    }

    public Service getService() {
        return this.service;
    }

    public Config setService(final Service service) {
        this.service = service;
        return this;
    }

    public Set<String> getQuotes() {
        return this.quotes;
    }

    public Config addQuote(final String quote) {
        this.quotes.add(quote);
        return this;
    }

    public Config addQuotes(final Collection<String> quotes) {
        this.quotes.addAll(quotes);
        return this;
    }

    public Set<String> getProperties() {
        return this.properties;
    }

    public Config addProperty(final Property property) {
        this.properties.add(property.getTagValue());
        return this;
    }

    public Config addProperties(final Collection<Property> properties) {
        for (final Property property : properties) {
            this.properties.add(property.getTagValue());
        }

        return this;
    }

    public String getUrl() {
        switch (this.service) {
            default:
            case YAHOO:
                return YAHOO_FINANCE_BASE_URL + YAHOO_FINANCE_STOCKS + StringUtils.join(this.getQuotes(), ",")
                        + YAHOO_FINANCE_PROPERTIES + StringUtils.join(this.getProperties(), "").replaceAll("0", "")
                        + YAHOO_FINANCE_OUTPUT_CSV;
        }
    }
}
