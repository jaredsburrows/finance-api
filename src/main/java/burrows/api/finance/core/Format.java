package burrows.api.finance.core;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Output;

public interface Format {
    public Quote withXML();

    public Quote withJSON();

    public Quote withCSV();

    public class Impl implements Format {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Quote withCSV() {
            return new Quote.Impl(this.config.setOutput(Output.CSV));
        }

        @Override
        public Quote withJSON() {
            return new Quote.Impl(this.config.setOutput(Output.JSON));
        }

        @Override
        public Quote withXML() {
            return new Quote.Impl(this.config.setOutput(Output.XML));
        }
    }
}
