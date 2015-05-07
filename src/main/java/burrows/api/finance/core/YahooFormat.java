package burrows.api.finance.core;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Output;

public interface YahooFormat extends Format {

    public class Impl implements YahooFormat {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Quote outputCSV() {
            return new Quote.Impl(this.config.setOutput(Output.CSV));
        }
    }
}
