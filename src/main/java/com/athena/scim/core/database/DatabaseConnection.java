package com.athena.scim.core.database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    private static Logger log= LogManager.getLogger(DatabaseConnection.class);
    private InputStream inputStream;
    public void getDatabaseValues(){
        log.info("Starting the database properties file reading");
        String fileName="db.properties";
        try {
            log.info("Starting the try Block");
            Properties properties=new Properties();
            inputStream=getClass().getClassLoader().getResourceAsStream(fileName);
            log.info("got the Input Stream "+inputStream);
            if(null!=inputStream){
                log.debug("Input Stream is not null ");
                properties.load(inputStream);
            }else{
                log.error("Database Properties FIle is missing "+fileName);
                throw new FileNotFoundException("Properties File Missing "+fileName+" not found in classpath");
            }
        }catch (Exception e){

        }
    }
//    public Connection getConnection(){
//        return ;
//    }
}
