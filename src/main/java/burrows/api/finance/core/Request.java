package burrows.api.finance.core;

import burrows.api.finance.model.Config;
import burrows.api.finance.model.Config.Service;

public interface Request {
    public Format withYahoo();

    public Format withGoogle();

    public class Impl implements Request {

        final private Config config = new Config();

        @Override
        public Format withYahoo() {
            return new Format.Impl(this.config.setService(Service.YAHOO));
        }

        @Override
        public Format withGoogle() {
            return new Format.Impl(this.config.setService(Service.GOOGLE));
        }
    }
}
