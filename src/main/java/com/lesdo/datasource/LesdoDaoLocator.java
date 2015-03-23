package com.lesdo.datasource;

import com.lesdo.datasource.dao.MainDao;
import com.lesdo.datasource.dao.MainDao2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangshan on 15/3/23.
 */
public class LesdoDaoLocator {

    private static ApplicationContext context;
    static{
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    public static MainDao getMainDao(){
        return (MainDao) context.getBean("mainDao");
    }

    public static MainDao2 getMainDao2(){
        return (MainDao2) context.getBean("mainDao2");
    }

}
