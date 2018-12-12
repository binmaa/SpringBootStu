package com.mab;

/**
 * Created by 马斌 on 2018/12/5.
 */
public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
        return helloProperties.getPrefix()+" "+name+""+helloProperties.getSuffix();
    }
}
