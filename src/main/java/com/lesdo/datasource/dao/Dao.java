package com.lesdo.datasource.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.apache.log4j.Logger;

/**
 * Created by jiangshan on 15/3/23.
 */
public abstract class Dao {

    private final Logger       logger         = Logger.getLogger(Dao.class);
    private       DB           db             = null;
    private       String       collectionName = null;
    private       DBCollection collection     = null;

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public DBCollection getCollection() {
        return collection;
    }

    protected void init() {
        logger.info("-------- Dao init -------collectionName:" + collectionName);
        if (!db.collectionExists(collectionName)) {
            db.createCollection(collectionName, new BasicDBObject());
        }
        collection = db.getCollection(collectionName);
    }

}
