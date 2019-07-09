package com.athena.scim.core;

import com.athena.scim.core.database.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

@SuppressWarnings("unchecked")
 class SchemasValue {
    private SchemasValue(){
        throw new IllegalStateException("Schema Class");
    }
    private static Logger log= LogManager.getLogger(SchemasValue.class);
     static String getValue() throws SQLException {
        log.debug("Starting the Schema Value Generation method");
        DatabaseConnection dbConnection=new DatabaseConnection();
        Connection databaseConnection=dbConnection.getConnection();
        JSONObject meta=new JSONObject();
        meta.put("location", "http://localhost:11080/jerseyRest/scim/Resources/Users");
        meta.put("resourceType", "Users");
        meta.put("created", "2010-01-23T04:56:22Z");
        meta.put("version", "1");
        meta.put("lastModified", "2011-05-13T04:42:34Z");
        String query="select * from world.city limit 1;";
        JSONObject schmaJson=new JSONObject();
        JSONArray attrbArray=new JSONArray();
            log.debug("Starting the try block");
            if(null!=databaseConnection){
                PreparedStatement ps=null;
                ResultSet resultSet=null;
                try{
                log.debug("Connection is not null");
                ps=databaseConnection.prepareStatement(query);
                resultSet=ps.executeQuery();
                log.info("Result set has additional value");
                ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
                log.debug("Starting to read the column Names ");
                for (int i = 0; i <resultSetMetaData.getColumnCount() ; i++) {
                    JSONObject tmpJson=new JSONObject();
                    tmpJson.put("name",resultSetMetaData.getColumnLabel(i+1));
                    tmpJson.put("type",resultSetMetaData.getColumnTypeName(i+1));
                    tmpJson.put("multiValued",false);
                    tmpJson.put("description","Attribute from the table");
                    tmpJson.put("returned","default");
                    tmpJson.put("required",(resultSetMetaData.isNullable(i+1)));
                    tmpJson.put("caseExact",resultSetMetaData.isCaseSensitive(i+1));
                    tmpJson.put("mutability",!(resultSetMetaData.isWritable(i+1)));
                    tmpJson.put("uniqueness","server");
                    attrbArray.add(tmpJson);
                }
            } catch (Exception e){
            log.error("Error occurred in catch block for the schema value generation.");
            log.error("Error is \t"+e);
            }finally {
                    if(null!=ps){
                    ps.close();}
                    if(null!=resultSet){
                    resultSet.close();}
                }
            }else{
                log.error("Connection is null nothing to do");
            }
        schmaJson.put("Attributes",attrbArray);
        return schmaJson.toString();
    }
}
