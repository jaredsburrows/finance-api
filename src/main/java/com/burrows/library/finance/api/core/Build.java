package com.burrows.library.finance.api.core;

import com.burrows.library.finance.api.model.Config;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

public interface Build {

    OkHttpClient client = new OkHttpClient();

    String build();

    Config buildConfig();

    String buildURL();

    class Impl implements Build {
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
