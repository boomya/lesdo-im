package com.lesdo.datasource.factory;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;

import java.net.UnknownHostException;

/**
 * Created by jiangshan on 15/3/20.
 */
public class MongoFactory implements FactoryBean<DB>{

    private final Logger logger = Logger.getLogger(MongoFactory.class);

    private String host = null;
    private int    port = 0;

    private Mongo  mongo    = null;
    private String dbName   = null;
    private String userName = null;
    private String password = null;

    private DB db = null;

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private synchronized void init(){
        logger.info("---- MongoFactory init ----");
        if(mongo != null){
            logger.info("---- MongoFactory init mongo!=null ----");
            return;
        }
        logger.info("---- MongoFactory create mongo ----");
        MongoOptions mgOptions = new MongoOptions();
        mgOptions.connectionsPerHost = 100;
        mgOptions.threadsAllowedToBlockForConnectionMultiplier = 100;
        mgOptions.maxWaitTime = 3600000;
        ServerAddress serverAddress = null;
        try {
            serverAddress = new ServerAddress(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        mongo = new Mongo(serverAddress, mgOptions);

        db = mongo.getDB(dbName);

        // 授权
        if (this.userName != null && !this.userName.trim().equals("")
            && this.password != null
            && !this.password.trim().equals("")) {
            // 输出认证结果
            System.out.println("MongoDB Authenticate:"
                               + db.authenticate(this.userName,
                                                 this.password.toCharArray()));
        }

    }

    @Override
    public DB getObject() throws Exception {
        logger.info("---- MongoFactory getDB ----");
        if(db == null){
            logger.info("---- MongoFactory getDB create ----");
            init();
        }
        return db;
    }

    @Override
    public Class<?> getObjectType() {
        return DB.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
