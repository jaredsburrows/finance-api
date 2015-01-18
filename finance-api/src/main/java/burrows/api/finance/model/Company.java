package burrows.api.finance.model;

/**
 * An enumeration that represents the companies that the API supports.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public enum Company {
    /** http://www.yahoo.com/ **/
    YAHOO(0, "YAHOO"),
    // TODO no support
    /** http://www.google.com/ **/
    GOOGLE(1, "GOOGLE");

    /** Integer value of the Enum. **/
    private final int intValue;
    /** String value of the Enum. **/
    private final String stringValue;

    /**
     * Company Enum
     * @param intValue Integer value of the Enum.
     * @param stringValue String value of the Enum.
     */
    private Company(final int intValue, final String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
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
     * Returns the integer value of this enum instance.
     *
     * @param intValue the integer value to determine the matching enum instance for.
     *
     * @return the enum instance for the specified int value, or {@code null} if there is no match.
     *
     * @see #getIntValue()
     * @since 0.0.1
     */
    public static Company fromInt(int intValue) {
        for (Company instance : values()) {
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
    public static Company fromString(String stringValue) {
        if (stringValue == null || stringValue.length() == 0) {
            return null;
        }

        for (Company instance : values()) {
            if (instance.stringValue.equalsIgnoreCase(stringValue)) {
                return instance;
            }
        }
        return null;
    }
}
