package burrows.api.finance.model

import burrows.api.finance.model.Config.Output
import burrows.api.finance.model.Config.Service
import burrows.api.finance.model.yahoo.Property
import spock.lang.Specification

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
class ConfigSpec extends Specification {

    Config config

    def "setup"() {
        config = new Config()
    }

    def "Service - count"() {
        expect:
        Service.values().length == 2
    }

    def "Service - ordinal"() {
        expect:
        Service.GOOGLE.ordinal() == 0
        Service.YAHOO.ordinal() == 1
    }

    def "Service - valueOf"() {
        expect:
        Service.valueOf(a) == b

        where:
        a        || b
        "GOOGLE" || Service.GOOGLE
        "YAHOO"  || Service.YAHOO
    }

    def "Output - count"() {
        expect:
        Output.values().length == 3
    }

    def "Output - ordinal"() {
        expect:
        Output.CSV.ordinal() == 0
        Output.JSON.ordinal() == 1
        Output.XML.ordinal() == 2
    }

    def "Output - valueOf"() {
        expect:
        Output.valueOf(a) == b

        where:
        a      || b
        "CSV"  || Output.CSV
        "JSON" || Output.JSON
        "XML"  || Output.XML
    }

    def "Output - getter/setter"() {
        when:
        config.setOutput(Output.XML)

        then:
        config.getOutput() == Output.XML
    }

    def "Service - getter/setter"() {
        when:
        config.setService(Service.GOOGLE)

        then:
        config.getService() == Service.GOOGLE
    }

    def "Quote - getter/setter"() {
        when:
        config.addQuote("MSFT")

        then:
        config.getQuotes() == ["MSFT"] as Set

        when:
        config.addQuotes(["GOOG", "MSFT"])

        then:
        config.getQuotes() == ["GOOG", "MSFT"] as Set
    }

    def "Properties - getter/setter"() {
        when:
        config.addProperty(Property.AfterHoursChangeRealtime)

        then:
        config.getProperties() == ["c8"] as Set

        when:
        config.addProperties([Property.AfterHoursChangeRealtime, Property.AnnualizedGain])

        then:
        config.getProperties() == ["c8", "g3"] as Set
    }

    def "default values"() {
        given:
        Config defaultConfig = new Config()

        expect:
        defaultConfig.getService() == Service.YAHOO
        defaultConfig.getOutput() == Output.CSV
        defaultConfig.getQuotes() == [] as Set
        defaultConfig.getProperties() == [] as Set
        defaultConfig.getUrl() == "http://download.finance.yahoo.com/d/quotes.csv?s=&f=&e=.csv"
    }

    def "getUrl"() {
        given:
        Config yahoo = new Config().addProperty(Property.Name).setOutput(Output.CSV).
                addQuote("MSFT")

        expect:
        yahoo.getService() == Service.YAHOO
        yahoo.getOutput() == Output.CSV
        yahoo.getQuotes() == ["MSFT"] as Set
        yahoo.getProperties() == [Property.Name.getTagValue()] as Set
        yahoo.getUrl() == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT&f=n&e=.csv"

        when:
        yahoo.setService(Service.GOOGLE)

        then:
        yahoo.getUrl() == "http://download.finance.yahoo.com/d/quotes.csv?s=MSFT&f=n&e=.csv"
    }
}
