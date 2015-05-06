package burrows.api.finance.core

import burrows.api.finance.model.Config.Output
import burrows.api.finance.model.Config.Service
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request.Builder
import spock.lang.Specification

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
class RequestSpec extends Specification {

    def "test url"() {
        given:
        OkHttpClient client = new OkHttpClient();

        when:
        Build requestUrl = Builders.request()
                .withYahoo()
                .outputCSV()
                .getQuote("MSFT");
        String test = client.newCall(new Builder().url("http://download.finance.yahoo.com/d/quotes.csv?s=MSFT").build()).execute().body().
                string();


        then:
        test == "test"
//        requestUrl.build() == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT"
        requestUrl.buildConfig().getService() == Service.YAHOO
        requestUrl.buildConfig().getOutput() == Output.CSV
        requestUrl.buildConfig().getQuotes() == ["MSFT"] as Set
        requestUrl.buildConfig().getProperties() == [] as LinkedHashSet
        requestUrl.buildURL() == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT"
    }
}
