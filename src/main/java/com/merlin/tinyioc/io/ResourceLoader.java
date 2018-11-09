package com.merlin.tinyioc.io;

import java.net.URL;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 10:47
 */
public class ResourceLoader {

    public Resource loadResource(String location) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
