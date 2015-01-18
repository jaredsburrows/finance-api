package burrows.api.finance.core;

import java.util.Collection;

import burrows.api.finance.model.Company;
import burrows.api.finance.model.Format;
import burrows.api.finance.model.RequestURLData;

/**
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public class RequestURL {

    private RequestURL() {

    }

    public static ICompany Builder() {
        return new RequestBuilder();
    }

    /**
     * Interface for selecting {@link burrows.api.finance.model.Company} API.
     */
    public static interface ICompany {
        IFormat withCompany(final Company company);
    }

    public static interface IFormat {
        IQuote withFormat(final Format format);
    }

    public static interface IQuote {
        IBuild addQuote(final String quotes);

        IBuild addQuotes(final Collection<String> quotes);
    }

    public static interface IBuild {
        RequestURLData build();

        String buildURL();
    }

    private static class RequestBuilder implements ICompany, IFormat, IQuote, IBuild {

        final RequestURLData requestURLData = new RequestURLData();

        @Override
        public IFormat withCompany(final Company company) {
            this.requestURLData.setCompany(company);
            return this;
        }

        @Override
        public IQuote withFormat(final Format format) {
            this.requestURLData.setFormat(format);
            return this;
        }

        @Override
        public IBuild addQuote(final String quotes) {
            this.requestURLData.addQuote(quotes);
            return this;
        }

        @Override
        public IBuild addQuotes(final Collection<String> quotes) {
            this.requestURLData.addQuotes(quotes);
            return this;
        }

        @Override
        public RequestURLData build() {
            return this.requestURLData;
        }

        @Override
        public String buildURL() {
            return new RequestURLSerializer(this.requestURLData).getURL();
        }
    }
}
