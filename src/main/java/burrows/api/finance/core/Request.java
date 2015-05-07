package burrows.api.finance.core;

import com.squareup.okhttp.OkHttpClient;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Service;

public interface Request {

    public OkHttpClient client = new OkHttpClient();

    public YahooProperties withYahoo();

    public Format withGoogle();

    public class Impl implements Request {

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
