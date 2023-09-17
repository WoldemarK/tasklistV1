package com.example.tasklist.service.props;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {

    private String host;
    private int port;
    private String username;
    private String password;
    private Properties properties;

}
