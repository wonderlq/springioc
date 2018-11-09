package com.merlin.tinyioc.beans.io;

import java.io.InputStream;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 10:40
 */
public interface Resource {
    InputStream getInputStream()throws Exception;
}
