package com.coolnimesh43.webservice.web.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "webservice", ignoreInvalidFields = false)
public class WebServiceProperties {

    private final Instance instance = new Instance();

    public Instance getInstance() {
        return instance;
    }

    public static class Instance {

        private final Persistence persistence = new Persistence();

        public Persistence getPersistence() {
            return persistence;
        }

        public static class Persistence {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }
    }
}
