package com.merlin.ioctest;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class SayWord {

    private String word;

    private HelloServer helloServer;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public HelloServer getHelloServer() {
        return helloServer;
    }

    public void setHelloServer(HelloServer helloServer) {
        this.helloServer = helloServer;
    }
}
