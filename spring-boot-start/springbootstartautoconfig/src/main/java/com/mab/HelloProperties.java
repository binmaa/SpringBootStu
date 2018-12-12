package com.mab;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by 马斌 on 2018/12/5.
 */
@ConfigurationProperties(prefix = "customstart.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
