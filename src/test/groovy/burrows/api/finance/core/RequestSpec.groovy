package burrows.api.finance.core
import burrows.api.finance.model.Config.Output
import burrows.api.finance.model.Config.Service
import burrows.api.finance.model.yahoo.Property
import spock.lang.Specification
/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
class RequestSpec extends Specification {


    /**
     * Builders -> request() -> withYahoo()  -> withProperty()   -> outputCSV() -> getQuote()
     *                                       -> withProperties()                -> getQuotes()
     *
     *
     *          -> request() -> withGoogle()                     -> outputCSV() -> getQuote()
     *                                                                          -> getQuotes()
     */
    // Yahoo supports - CSV - Yahoo CSV API
    // Yahoo supports - JSON + XML - Yahoo YQL API
    def "yahoo - csv"() {
        when:
        Build yahoo = Builders.request().withYahoo().withProperty(Property.Name).outputCSV().
                getQuote("MSFT");

        then:
        yahoo.build() == "\"Microsoft Corporation\""
        yahoo.buildConfig().getService() == Service.YAHOO
        yahoo.buildConfig().getOutput() == Output.CSV
        yahoo.buildConfig().getQuotes() == ["MSFT"] as Set
        yahoo.buildConfig().getProperties() == [Property.Name.getTagValue()] as LinkedHashSet
        yahoo.buildURL() == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT&f=n&e=.csv"
    }
}
