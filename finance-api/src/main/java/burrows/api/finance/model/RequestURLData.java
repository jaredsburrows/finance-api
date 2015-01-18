package burrows.api.finance.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Request URL Data for creating HTTP requests.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @see burrows.api.finance.model.Company
 * @see burrows.api.finance.model.Format
 * @see burrows.api.finance.model.Property
 * @since 0.0.1
 */
public class RequestURLData {

    private Set<String> quotes = new LinkedHashSet<>();
    private Company company;
    private Format format;

    public Company getCompany() {
        return this.company;
    }

    public RequestURLData setCompany(final Company company) {
        this.company = company;
        return this;
    }

    public Format getFormat() {
        return this.format;
    }

    public RequestURLData setFormat(final Format format) {
        this.format = format;
        return this;
    }

    public Set<String> getQuotes() {
        return this.quotes;
    }

    public RequestURLData addQuote(final String quotes) {
        this.quotes.add(quotes);
        return this;
    }

    public RequestURLData addQuotes(final Collection<String> quotes) {
        this.quotes.addAll(quotes);
        return this;
    }
}
