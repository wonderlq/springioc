package com.merlin.tinyioc.beans.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 10:41
 */
public class UrlResource implements Resource{

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception{
       URLConnection connection = url.openConnection();
       return  connection.getInputStream();
    }
}
