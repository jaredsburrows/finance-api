package com.burrows.library.finance.api.core;

import com.burrows.library.finance.api.model.Config;
import com.squareup.okhttp.OkHttpClient;

public interface Request {

    OkHttpClient client = new OkHttpClient();

    YahooProperties withYahoo();

    Format withGoogle();

    class Impl implements Request {

        final private Config config = new Config();

        @Override
        public YahooProperties withYahoo() {
            return new YahooProperties.Impl(this.config.setService(Config.Service.YAHOO));
        }

        @Override
        public Format withGoogle() {
            return new Format.Impl(this.config.setService(Config.Service.GOOGLE));
        }
    }
}
