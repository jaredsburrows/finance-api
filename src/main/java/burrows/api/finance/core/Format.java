package burrows.api.finance.core;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Output;

public interface Format {

    public Quote outputCSV();

    public Quote outputJSON();

    public Quote outputXML();

    public class Impl implements Format {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Quote outputCSV() {
            return new Quote.Impl(this.config.setOutput(Output.CSV));
        }

        @Override
        public Quote outputJSON() {
            return new Quote.Impl(this.config.setOutput(Output.JSON));
        }

        @Override
        public Quote outputXML() {
            return new Quote.Impl(this.config.setOutput(Output.XML));
        }
    }
}
