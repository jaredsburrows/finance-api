package burrows.api.finance.core;

import burrows.api.finance.model.Config;

public interface Build {
    public Config build();

    public String buildURL();

    public class Impl implements Build {
        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public Config build() {
            return this.config;
        }

        @Override
        public String buildURL() {
            return this.config.getUrl();
        }
    }
}
