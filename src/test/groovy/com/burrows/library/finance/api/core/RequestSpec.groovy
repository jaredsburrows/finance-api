package com.burrows.library.finance.api.core

import com.burrows.library.finance.api.model.yahoo.Property
import spock.lang.Specification

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 * @since 0.0.1
 */
class RequestSpec extends Specification {

    /**
     * StockRequest.Builders() -> request() -> withYahoo()  -> withProperty()   -> outputCSV() -> getQuote()
     *                                       -> withProperties()                -> getQuotes()
     *
     *
     *          -> request() -> withGoogle()                     -> outputCSV() -> getQuote()
     *                                                                          -> getQuotes()
     */
    // Yahoo supports - CSV - Yahoo CSV API
    // Yahoo supports - JSON + XML - Yahoo YQL API
    def "yahoo - csv"() {
        expect:
        Build yahoo = Builders.request()
                .withYahoo()
                .withProperty(Property.Name)
                .outputCSV()
                .getQuote("MSFT")

//        StockRequest builder = new StockRequest.Builder()
//                .withYahoo()
//                .withQuote("MSFT")
//                .build();

//        StepBuilder.newBuilder().name("asdf").onLocalhost().build()
//        StepBuilder.newBuilder().name("asdf").onRemotehost("asdf").credentials("asdf", "asdf").build()
    }

    public class StepBuilder2 {
        public static NameStep newBuilder() {
            return new Steps();
        }

        private StepBuilder() {
        }

        public static interface NameStep {
            /**
             * @param name
             *            unique identifier for this User Configuration
             * @return ServerStep
             */
            ServerStep name(String name);
        }

        public static interface ServerStep {
            /**
             * The hostname of the server where the User Configuration file is stored will be set to "localhost".
             *
             * @return BuildStep
             */
            public BuildStep onLocalhost();

            /**
             * The hostname of the server where the User Configuration file is stored.
             *
             * @return CredentialsStep
             */
            public CredentialsStep onRemotehost(String host);
        }

        public static interface CredentialsStep {
            /**
             * Username required to connect to remote machine Password required to connect to remote machine
             *
             * @return BuildStep
             */
            public BuildStep credentials(String user, String password);
        }

        public static interface BuildStep {
            /**
             * @return an instance of a UserConfiguration based on the parameters passed during the creation.
             */
            public String build();
        }

        private static class Steps implements NameStep, ServerStep, CredentialsStep, BuildStep {

            private String name;
            private String host;
            private String user;
            private String password;

            public BuildStep onLocalhost() {
                this.host = "localhost";
                return this;
            }

            public ServerStep name(String name) {
                this.name = name;
                return null;
            }

            public CredentialsStep onRemotehost(String host) {
                this.host = host;
                return this;
            }

            public BuildStep credentials(String user, String password) {
                this.user = user;
                this.password = password;
                return this;
            }

            public String build() {
                return "userConfiguration";
            }
        }
    }
}
