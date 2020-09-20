package com.thoughtworks.capability.gtb.demospringconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("mail")
@Data
public class MailConfig {

    private String hostname;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, Boolean> additionalHeaders;
    private Credentials credentials;


    @Override
    public String toString() {
        return "MailConfig{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                ", from='" + from + '\'' +
                ", defaultRecipients[0]='" + defaultRecipients.get(0) + '\'' +
                ", defaultRecipients[1]='" + defaultRecipients.get(1) + '\'' +
                ", additionalHeaders.redelivery=" + additionalHeaders.get("redelivery") +
                ", additionalHeaders.secure=" + additionalHeaders.get("secure") +
                ", credentials.username='" + credentials.getUsername() + '\'' +
                ", credentials.password='" + credentials.getPassword() + '\'' +
                ", credentials.authMethod='" + credentials.getAuthMethod() + '\'' +
                '}';
    }

    @Data
    private static class Credentials {
        private String username;
        private String password;
        private String authMethod;
    }
}
