package burrows.api.finance.core;

import burrows.api.finance.model.Config;

import java.util.Arrays;
import java.util.Collection;

public interface Quote {

    Build getQuote(final String quotes);

    Build getQuotes(final Collection<String> quotes);

    Build getQuotes(final String... quotes);

    class Impl implements Quote {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Build getQuote(final String quote) {
            return new Build.Impl(this.config.addQuote(quote));
        }

        @Override
        public Build getQuotes(final Collection<String> quotes) {
            return new Build.Impl(this.config.addQuotes(quotes));
        }

        @Override
        public Build getQuotes(final String... quotes) {
            return new Build.Impl(this.config.addQuotes(Arrays.asList(quotes)));
        }
    }
}
