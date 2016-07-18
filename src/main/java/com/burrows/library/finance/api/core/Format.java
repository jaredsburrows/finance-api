package com.burrows.library.finance.api.core;

import com.burrows.library.finance.api.model.Config;

public interface Format {

    Quote outputCSV();

//    public Quote outputJSON();
//    public Quote outputXML();

    class Impl implements Format {

        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Quote outputCSV() {
            return new Quote.Impl(this.config.setOutput(Config.Output.CSV));
        }

//        @Override
//        public Quote outputJSON() {
//            return new Quote.Impl(this.config.setOutput(Output.JSON));
//        }
//        @Override
//        public Quote outputXML() {
//            return new Quote.Impl(this.config.setOutput(Output.XML));
//        }
    }
}
