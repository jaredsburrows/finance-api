package burrows.api.finance.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class FormatTest {

    @Test
    public void testIntValue() {
        assertThat(Format.XML.getIntValue(), is(1));
        assertThat(Format.JSON.getIntValue(), is(2));
    }

    @Test
    public void testStringValue() {
        assertThat(Format.XML.getStringValue(), is("XML"));
        assertThat(Format.JSON.getStringValue(), is("JSON"));
    }

    @Test
    public void testFromInt() {
        assertThat(Format.fromInt(1), is(Format.XML));
        assertThat(Format.fromInt(2), is(Format.JSON));
    }

    @Test
    public void testFromString() {
        assertThat(Format.fromString("XML"), is(Format.XML));
        assertThat(Format.fromString("JSON"), is(Format.JSON));
    }

    // TODO Java 8
//    @Test
//    public void testFromString() {
//        assertThat(Format.fromString("XML").get(), is(Format.XML));
//        assertThat(Format.fromString("JSON").get(), is(Format.JSON));
//    }
//
//    @Test
//    public void testFromInt() {
//        assertThat(Format.fromInt(0).get(), is(Format.XML));
//        assertThat(Format.fromInt(1).get(), is(Format.JSON));
//    }
}
