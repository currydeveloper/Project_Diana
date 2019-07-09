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
    public Properties getDatabaseValues(){
        log.info("Starting the database properties file reading");
        String fileName="db.properties";
        InputStream inputStream;
        Properties properties=new Properties();
        try {
            log.info("Starting the try Block");
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
        log.error("Error in the Database Connection for Catch Block");
        log.error("Error is "+e);
        }
        return properties;
    }
    public Connection getConnection(){
        log.debug("Starting the get Connection Method");
        log.info("Retrieving Properties from the getDB Values method");
        Properties dbProperties=getDatabaseValues();
        Connection dbConnection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            log.debug("Starting the try block in the getConnection method.");
            String url=(String) dbProperties.get("url");
            String uname=dbProperties.getProperty("username");
            String password=dbProperties.getProperty("password");
            dbConnection=DriverManager.getConnection(url,uname,password);
        }
        catch (Exception e){
            log.error("Error occured in the GetConnection method with the following error : \t"+e);
        }
        return dbConnection;
    }
}
