package com.example.tasklist.service.props;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String secret;
    private long access;
    private long refresh;

}
