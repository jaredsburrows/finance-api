package burrows.api.finance.model;

/**
 * An enumeration that represents the formats that the API supports.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
public enum Format {
    DEFAULT(0, "DEFAULT"),
    // TODO not supported
    XML(1, "XML"),
    JSON(2, "JSON");

    private final int intValue;
    private final String stringValue;

    private Format(final int intValue, final String stringValue) {
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
    public static Format fromInt(int intValue) {
        for (Format instance : values()) {
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
    public static Format fromString(String stringValue) {
        if (stringValue == null || stringValue.length() == 0) {
            return null;
        }

        for (Format instance : values()) {
            if (instance.stringValue.equalsIgnoreCase(stringValue)) {
                return instance;
            }
        }
        return null;
    }
}
