package com.burrows.library.finance.api.core;

public class StepBuilder {
    public static NameStep newBuilder() {
        return new Steps();
    }

    private StepBuilder() {
    }

    public static interface NameStep {
        /**
         * @param name unique identifier for this User Configuration
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
