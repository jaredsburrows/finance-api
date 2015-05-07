package burrows.api.finance.core;

import java.util.Arrays;
import java.util.Collection;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.yahoo.Property;

public interface YahooProperties {

    public YahooFormat withProperty(final Property property);

    public YahooFormat withProperties(final Collection<Property> properties);

    public YahooFormat withProperties(final Property... properties);

    public class Impl implements YahooProperties {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public YahooFormat withProperty(final Property property) {
            return new YahooFormat.Impl(this.config.addProperty(property));
        }

        @Override
        public YahooFormat withProperties(final Collection<Property> properties) {
            return new YahooFormat.Impl(this.config.addProperties(properties));
        }

        @Override
        public YahooFormat withProperties(final Property... properties) {
            return new YahooFormat.Impl(this.config.addProperties(Arrays.asList(properties)));
        }
    }
}
