package com.burrows.library.finance.api.core;

import com.burrows.library.finance.api.model.Config;

public interface YahooFormat extends Format {

    class Impl implements YahooFormat {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Quote outputCSV() {
            return new Quote.Impl(this.config.setOutput(Config.Output.CSV));
        }
    }
}
