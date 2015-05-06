package burrows.api.finance.core

import spock.lang.Specification

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
class RequestSpec extends Specification {

    def "test url"() {

        given:
        String requestUrl = Builders.request()
                .withYahoo()
                .withJSON()
                .getQuote("MSFT")
                .buildURL();


        expect:
        requestUrl == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT"
    }
}
