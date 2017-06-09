package com.ssh.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Value("${web.login.check}")
    private String loginCheck;

    // @Value("${web.login.session.timeout}")
    // private Long loginSessionTimeout;

    public boolean isLoginCheck(boolean def) {
        if (loginCheck != null && "".equals(loginCheck)) {
            return Boolean.parseBoolean(loginCheck);
        } else {
            return def;
        }
    }

    public boolean isLoginCheck() {
        return Boolean.parseBoolean(loginCheck);
    }

    /*
     * public Long getLoginSessionTimeout() { return loginSessionTimeout; }
     */

}
