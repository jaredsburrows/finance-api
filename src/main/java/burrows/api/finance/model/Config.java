package burrows.api.finance.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import burrows.api.finance.model.yahoo.Property;

/**
 * Request URL Data for creating HTTP requests.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @see burrows.api.finance.model.yahoo.Property
 * @since 0.0.1
 */
public class Config {
    private final static String YAHOO_FINANCE_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";

    private Set<String> quotes = new LinkedHashSet<>();
    private Set<Property> properties = new LinkedHashSet<>();
    private Service service = Service.YAHOO;
    private Output output = Output.CSV;

    public enum Service {
        GOOGLE,
        YAHOO
    }

    public enum Output {
        CSV,
        JSON,
        XML
    }

    public Config setService(final Service service) {
        Assert.assertNotNull("Service can't be null.", service);
        this.service = service;
        return this;
    }

    public Service getService() {
        return this.service;
    }

    public Config setOutput(final Output output) {
        Assert.assertNotNull("Output can't be null.", output);
        this.output = output;
        return this;
    }

    public Output getOutput() {
        return this.output;
    }

    public Set<Property> getProperties() {
        return this.properties;
    }

    public Config addProperty(final Property property) {
        Assert.assertNotNull("Property can't be null.", property);
        this.properties.add(property);
        return this;
    }

    public Config addProperties(final Collection<Property> properties) {
        Assert.assertNotNull("Properties can't be null.", properties);
        this.properties.addAll(properties);
        return this;
    }

    public Set<String> getQuotes() {
        return this.quotes;
    }

    public Config addQuote(final String quote) {
        Assert.assertNotNull("Quote can't be null.", quote);
        this.quotes.add(quote);
        return this;
    }

    public Config addQuotes(final Collection<String> quotes) {
        Assert.assertNotNull("Quotes can't be null.", quotes);
        this.quotes.addAll(quotes);
        return this;
    }

    public String getUrl() {
        if (this.service == Service.YAHOO) {
            return YAHOO_FINANCE_BASE_URL + StringUtils.join(this.getQuotes(), ",");
        } else {
            throw new UnsupportedOperationException("No supported");
        }
    }
}
