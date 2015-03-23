package com.lesdo.datasource;

import com.lesdo.datasource.dao.MainDao;
import com.lesdo.datasource.dao.MainDao2;

/**
 * Created by jiangshan on 15/3/20.
 */
public class Main {

    public static void main(String[] args) {
        new Main().test();

    }

    private void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
//        MainDao dao = (MainDao) context.getBean("mainDao");
//        System.out.println(" dao: " + dao + " " + dao.getDb().hashCode());
//        System.out.println(" dao: " + dao + " " + dao.getDb().hashCode());
//        MainDao2 dao2 = (MainDao2) context.getBean("mainDao2");
//        System.out.println(" dao2: " + dao2 + " " + dao2.getDb().hashCode());
//        System.out.println(" dao2: " + dao2 + " " + dao2.getDb().hashCode());

        MainDao dao = LesdoDaoLocator.getMainDao();
        System.out.println(" dao: " + dao + " " + dao.getDb().hashCode());
        System.out.println(" dao: " + dao + " " + dao.getDb().hashCode());
        MainDao2 dao2 = LesdoDaoLocator.getMainDao2();
        System.out.println(" dao2: " + dao2 + " " + dao2.getDb().hashCode());
        System.out.println(" dao2: " + dao2 + " " + dao2.getDb().hashCode());

        dao.getPostResponse("32957_5419");
    }
}
