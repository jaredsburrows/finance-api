package burrows.api.finance.core;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import burrows.api.finance.model.Config;

public interface Build {

    public OkHttpClient client = new OkHttpClient();

    public String build();

    public Config buildConfig();

    public String buildURL();

    public class Impl implements Build {
        final private Config config;

        public Impl(final Config config) {
            this.config = config;
        }

        @Override
        public String build() {
            String data = null;
            try {
                data = run(this.config.getUrl());
            } catch (final IOException e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        public Config buildConfig() {
            return this.config;
        }

        @Override
        public String buildURL() {
            return this.config.getUrl();
        }

        private String run(final String url) throws IOException {
            return client.newCall(new Request.Builder().url(url).build()).execute().body().string().trim();
        }
    }
}
