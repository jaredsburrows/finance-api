package burrows.api.finance.core;

import com.squareup.okhttp.OkHttpClient;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Service;

public interface Request {

    OkHttpClient client = new OkHttpClient();

    YahooProperties withYahoo();

    Format withGoogle();

    class Impl implements Request {

        final private Config config = new Config();

        @Override
        public YahooProperties withYahoo() {
            return new YahooProperties.Impl(this.config.setService(Service.YAHOO));
        }

        @Override
        public Format withGoogle() {
            return new Format.Impl(this.config.setService(Service.GOOGLE));
        }
    }
}
