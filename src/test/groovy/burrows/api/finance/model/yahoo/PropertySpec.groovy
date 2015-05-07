package burrows.api.finance.model.yahoo

import spock.lang.Specification

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class PropertySpec extends Specification {

    def "count"() {
        expect:
        Property.values().length == 88
    }

    def "IntValue"() {
        expect:
        Property.AfterHoursChangeRealtime.getIntValue() == 0
        Property.AnnualizedGain.getIntValue() == 1
    }

    def "StringValue"() {
        expect:
        Property.AfterHoursChangeRealtime.getStringValue() == "AfterHoursChangeRealtime"
        Property.AnnualizedGain.getStringValue() == "AnnualizedGain"
    }

    def "TagValue"() {
        expect:
        Property.AfterHoursChangeRealtime.getTagValue() == "c8"
        Property.AnnualizedGain.getTagValue() == "g3"
    }

    def "FromInt"() {
        expect:
        Property.fromInt(a) == b

        where:
        a  || b
        -1 || null
        0  || Property.AfterHoursChangeRealtime
        1  || Property.AnnualizedGain
    }

    def "FromString"() {
        expect:
        Property.fromString(a) == b

        where:
        a                          || b
        null                       || null
        "cant find"                || null
        ""                         || null
        "AfterHoursChangeRealtime" || Property.AfterHoursChangeRealtime
        "AnnualizedGain"           || Property.AnnualizedGain
    }

    def "FromTag"() {
        expect:
        Property.fromTag(a) == b

        where:
        a           || b
        null        || null
        "cant find" || null
        ""          || null
        "c8"        || Property.AfterHoursChangeRealtime
        "g3"        || Property.AnnualizedGain
    }

    def "valueOf"() {
        expect:
        Property.valueOf(a) == b

        where:
        a                          || b
        "AfterHoursChangeRealtime" || Property.AfterHoursChangeRealtime
        "AnnualizedGain"           || Property.AnnualizedGain
    }
}
