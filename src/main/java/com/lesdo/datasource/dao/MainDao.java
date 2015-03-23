package com.lesdo.datasource.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

/**
 * Created by jiangshan on 15/3/20.
 */
public class MainDao extends Dao {

    private final Logger logger = Logger.getLogger(MainDao.class);

    //获取求回应信息
    public void getPostResponse(String postResponseId) {
        BasicDBObject where = new BasicDBObject();
        where.put("_id", postResponseId);
        DBObject dbObject = getCollection().findOne(where);
        if (dbObject != null) {
            logger.info(dbObject.get("_id") + " " + dbObject.get("content"));
        }
        logger.info(" getPostResponse null. ");
    }
}
