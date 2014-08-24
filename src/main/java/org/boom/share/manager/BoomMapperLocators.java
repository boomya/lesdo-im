package org.boom.share.manager;

import org.boom.share.manager.dao.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangshan on 14/8/22.
 */
public class BoomMapperLocators {

    private static ApplicationContext context;
    private static RuntimeException initException = null;

    static {
        try {
            context = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");
        } catch (RuntimeException e) {
            initException = e;
        }
    }

    public static ApplicationContext getApplicationContext() {
        if (context == null) {
            throw initException;
        }
        return context;
    }

    public static UserMapper getUserMapper() {
        return (UserMapper) getApplicationContext().getBean("userMapper");
    }
}
