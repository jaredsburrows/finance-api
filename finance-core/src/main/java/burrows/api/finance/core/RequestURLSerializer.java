package burrows.api.finance.core;

import org.apache.commons.lang3.StringUtils;

import burrows.api.finance.model.RequestURLData;

/**
 *
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public class RequestURLSerializer {

    private final static String YAHOO_FINANCE_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";
    private RequestURLData requestURLData;
    private StringBuilder requestURL = new StringBuilder();

    public RequestURLSerializer(final RequestURLData requestURLData) {
        this.requestURLData = requestURLData;
    }

    public String getURL() {
        return requestURL.append(this.getCompany())
                .append(this.getFormat())
                .append(this.getQuotes())
                .toString();
    }

    private String getCompany() {
        switch (this.requestURLData.getCompany()) {
            default:
            case YAHOO:
                return YAHOO_FINANCE_BASE_URL;

            case GOOGLE:
                throw new UnsupportedOperationException("Not supported.");
        }
    }

    private String getFormat() {
        switch (this.requestURLData.getFormat()) {
            default:
            case DEFAULT:
                // do nothing
                break;
            case XML:
            case JSON:
                throw new UnsupportedOperationException("Not supported.");
        }
        return "";
    }

    private String getQuotes() {
        return StringUtils.join(this.requestURLData.getQuotes(), ",");
    }
}
