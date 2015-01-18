package burrows.api.finance.model;

/**
 * An enumeration that represents the companies that the Yahoo API supports.
 * <p>
 * Basic Bash Script for adding Enums:
 * </p>
 * <pre>
 * {@code
 * pbpaste | awk 'BEGIN { OFS="\t"} { printf "%s(%d, \"%s\", \"%s\"),\n", $1, NR-1, $1, $(NF) }' | pbcopy
 * pbpaste | awk 'BEGIN { OFS="\t"} { printf "%s(%d, \"%s\", \"%s\"),\n", toupper($1), NR-1, $1, $(NF) }' | pbcopy
 * }
 * </pre>
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @see <a href="https://code.google.com/p/yahoo-finance-managed/wiki/enumQuoteProperty">https://code.google.com/p/yahoo-finance-managed/wiki/enumQuoteProperty</a>
 * @since 0.0.1
 */
public enum Property {
    AfterHoursChangeRealtime(0, "AfterHoursChangeRealtime", "c8"),
    AnnualizedGain(1, "AnnualizedGain", "g3"),
    Ask(2, "Ask", "a0"),
    AskRealtime(3, "AskRealtime", "b2"),
    AskSize(4, "AskSize", "a5"),
    AverageDailyVolume(5, "AverageDailyVolume", "a2"),
    Bid(6, "Bid", "b0"),
    BidRealtime(7, "BidRealtime", "b3"),
    BidSize(8, "BidSize", "b6"),
    BookValuePerShare(9, "BookValuePerShare", "b4"),
    Change(10, "Change", "c1"),
    Change_ChangeInPercent(11, "Change_ChangeInPercent", "c0"),
    ChangeFromFiftydayMovingAverage(12, "ChangeFromFiftydayMovingAverage", "m7"),
    ChangeFromTwoHundreddayMovingAverage(13, "ChangeFromTwoHundreddayMovingAverage", "m5"),
    ChangeFromYearHigh(14, "ChangeFromYearHigh", "k4"),
    ChangeFromYearLow(15, "ChangeFromYearLow", "j5"),
    ChangeInPercent(16, "ChangeInPercent", "p2"),
    ChangeInPercentRealtime(17, "ChangeInPercentRealtime", "k2"),
    ChangeRealtime(18, "ChangeRealtime", "c6"),
    Commission(19, "Commission", "c3"),
    Currency(20, "Currency", "c4"),
    DaysHigh(21, "DaysHigh", "h0"),
    DaysLow(22, "DaysLow", "g0"),
    DaysRange(23, "DaysRange", "m0"),
    DaysRangeRealtime(24, "DaysRangeRealtime", "m2"),
    DaysValueChange(25, "DaysValueChange", "w1"),
    DaysValueChangeRealtime(26, "DaysValueChangeRealtime", "w4"),
    DividendPayDate(27, "DividendPayDate", "r1"),
    TrailingAnnualDividendYield(28, "TrailingAnnualDividendYield", "d0"),
    TrailingAnnualDividendYieldInPercent(29, "TrailingAnnualDividendYieldInPercent", "y0"),
    DilutedEPS(30, "DilutedEPS", "e0"),
    EBITDA(31, "EBITDA", "j4"),
    EPSEstimateCurrentYear(32, "EPSEstimateCurrentYear", "e7"),
    EPSEstimateNextQuarter(33, "EPSEstimateNextQuarter", "e9"),
    EPSEstimateNextYear(34, "EPSEstimateNextYear", "e8"),
    ExDividendDate(35, "ExDividendDate", "q0"),
    FiftydayMovingAverage(36, "FiftydayMovingAverage", "m3"),
    SharesFloat(37, "SharesFloat", "f6"),
    HighLimit(38, "HighLimit", "l2"),
    HoldingsGain(39, "HoldingsGain", "g4"),
    HoldingsGainPercent(40, "HoldingsGainPercent", "g1"),
    HoldingsGainPercentRealtime(41, "HoldingsGainPercentRealtime", "g5"),
    HoldingsGainRealtime(42, "HoldingsGainRealtime", "g6"),
    HoldingsValue(43, "HoldingsValue", "v1"),
    HoldingsValueRealtime(44, "HoldingsValueRealtime", "v7"),
    LastTradeDate(45, "LastTradeDate", "d1"),
    LastTradePriceOnly(46, "LastTradePriceOnly", "l1"),
    LastTradeRealtimeWithTime(47, "LastTradeRealtimeWithTime", "k1"),
    LastTradeSize(48, "LastTradeSize", "k3"),
    LastTradeTime(49, "LastTradeTime", "t1"),
    LastTradeWithTime(50, "LastTradeWithTime", "l0"),
    LowLimit(51, "LowLimit", "l3"),
    MarketCapitalization(52, "MarketCapitalization", "j1"),
    MarketCapRealtime(53, "MarketCapRealtime", "j3"),
    MoreInfo(54, "MoreInfo", "i0"),
    Name(55, "Name", "n0"),
    Notes(56, "Notes", "n4"),
    OneyrTargetPrice(57, "OneyrTargetPrice", "t8"),
    Open(58, "Open", "o0"),
    OrderBookRealtime(59, "OrderBookRealtime", "i5"),
    PEGRatio(60, "PEGRatio", "r5"),
    PERatio(61, "PERatio", "r0"),
    PERatioRealtime(62, "PERatioRealtime", "r2"),
    PercentChangeFromFiftydayMovingAverage(63, "PercentChangeFromFiftydayMovingAverage", "m8"),
    PercentChangeFromTwoHundreddayMovingAverage(64, "PercentChangeFromTwoHundreddayMovingAverage", "m6"),
    ChangeInPercentFromYearHigh(65, "ChangeInPercentFromYearHigh", "k5"),
    PercentChangeFromYearLow(66, "PercentChangeFromYearLow", "j6"),
    PreviousClose(67, "PreviousClose", "p0"),
    PriceBook(68, "PriceBook", "p6"),
    PriceEPSEstimateCurrentYear(69, "PriceEPSEstimateCurrentYear", "r6"),
    PriceEPSEstimateNextYear(70, "PriceEPSEstimateNextYear", "r7"),
    PricePaid(71, "PricePaid", "p1"),
    PriceSales(72, "PriceSales", "p5"),
    Revenue(73, "Revenue", "s6"),
    SharesOwned(74, "SharesOwned", "s1"),
    SharesOutstanding(75, "SharesOutstanding", "j2"),
    ShortRatio(76, "ShortRatio", "s7"),
    StockExchange(77, "StockExchange", "x0"),
    Symbol(78, "Symbol", "s0"),
    TickerTrend(79, "TickerTrend", "t7"),
    TradeDate(80, "TradeDate", "d2"),
    TradeLinks(81, "TradeLinks", "t6"),
    TradeLinksAdditional(82, "TradeLinksAdditional", "f0"),
    TwoHundreddayMovingAverage(83, "TwoHundreddayMovingAverage", "m4"),
    Volume(84, "Volume", "v0"),
    YearHigh(85, "YearHigh", "k0"),
    YearLow(86, "YearLow", "j0"),
    YearRange(87, "YearRange", "w0");

    private final int intValue;
    private final String stringValue;
    private final String tagValue;

    private Property(final int intValue, final String stringValue, final String tagValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.tagValue = tagValue;
    }

    /**
     * Returns the integer value of this enum instance.
     *
     * @return the integer value of this enum instance.
     *
     * @see #fromInt(int)
     * @since 0.0.1
     */
    public int getIntValue() {
        return this.intValue;
    }

    /**
     * Returns the underlying {@link #stringValue} of this instance.
     *
     * @return the underlying {@link #stringValue} of this instance.
     *
     * @see #fromString(String)
     * @since 0.0.1
     */
    public String getStringValue() {
        return this.stringValue;
    }

    /**
     * Returns the underlying {@link #tagValue} of this instance.
     *
     * @return the underlying {@link #tagValue} of this instance.
     *
     * @see #fromTag(String)
     * @since 0.0.1
     */
    public String getTagValue() {
        return this.tagValue;
    }

    /**
     * Returns the integer value of this enum instance.
     *
     * @param intValue the integer value to determine the matching enum instance for.
     *
     * @return the enum instance for the specified int value, or {@code null} if there is no match.
     *
     * @see #getIntValue()
     * @since 0.0.1
     */
    public static Property fromInt(int intValue) {
        for (Property instance : values()) {
            if (instance.intValue == intValue) {
                return instance;
            }
        }
        return null;
    }

    /**
     * Returns the enum instance for the specified string.
     *
     * @param stringValue the string value to determine the matching enum instance for.
     *
     * @return the enum instance for the specified string, or {@code null} if there is no match.
     *
     * @see #getStringValue()
     * @since 0.0.1
     */
    public static Property fromString(String stringValue) {
        if (stringValue == null || stringValue.length() == 0) {
            return null;
        }

        for (Property instance : values()) {
            if (instance.stringValue.equalsIgnoreCase(stringValue)) {
                return instance;
            }
        }
        return null;
    }

    /**
     * Returns the enum instance for the specified string for tag.
     *
     * @param tagValue the string value to determine the matching enum instance for.
     *
     * @return the enum instance for the specified string, or {@code null} if there is no match.
     *
     * @see #getTagValue()
     * @since 0.0.1
     */
    public static Property fromTag(String tagValue) {
        if (tagValue == null || tagValue.length() == 0) {
            return null;
        }

        for (Property instance : values()) {
            if (instance.tagValue.equalsIgnoreCase(tagValue)) {
                return instance;
            }
        }
        return null;
    }
}
