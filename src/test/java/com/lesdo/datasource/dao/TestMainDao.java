package com.lesdo.datasource.dao;

import com.lesdo.datasource.LesdoDaoLocator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiangshan on 14/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestMainDao {

    private static Logger logger = Logger.getLogger(TestMainDao.class);

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void testMainDao() {
        MainDao dao = LesdoDaoLocator.getMainDao();
        dao.getPostResponse("32957_5419");
    }
}
