package com.merlin.ioctest;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class HelloServer {

    private String name;
    private SayWord sayWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SayWord getSayWord() {
        return sayWord;
    }

    public void setSayWord(SayWord sayWord) {
        this.sayWord = sayWord;
    }
}
