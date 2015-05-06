package burrows.api.finance.core;

import java.util.Arrays;
import java.util.Collection;

import burrows.api.finance.model.Config;

public interface Quote {
    public Build getQuote(final String quotes);

    public Build getQuotes(final Collection<String> quotes);

    public Build getQuotes(final String... quotes);

    public class Impl implements Quote {

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
