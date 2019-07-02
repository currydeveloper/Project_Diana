package com.athena.scim.core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unchecked")
public class ResourceTypeValue {
    private static Logger log=LogManager.getLogger(ResourceTypeValue.class);
    public static String getValue() {
        log.debug("Starting the Building of JSON Object for the ResourceType");
        log.debug("Starting the log file");
        JSONObject resourceTypes=new JSONObject();
        resourceTypes.put("totalResults", 1);
        JSONArray schemas=new JSONArray();
        schemas.add("urn:ietf:params:scim:api:messages:2.0:ListResponse");
        resourceTypes.put("schemas", schemas);
        JSONArray resources=new JSONArray();
        JSONObject type=new JSONObject();
        type.put("schema", "urn:ietf:params:scim:schemas:core:2.0:User");
        type.put("endpoint",  "/Users");
        JSONObject meta=new JSONObject();
        meta.put("location", "http://localhost:13080/scim/v1/ResourceTypes");
        meta.put("resourceType", "ResourceType");
        type.put("meta", meta);
        JSONArray schema=new JSONArray();
        schema.add("urn:ietf:params:scim:schemas:core:2.0:ResourceType");
        type.put("schemas", schema);
        type.put("name","User");
        type.put("description","User Account");
        JSONObject schemaExtensions=new JSONObject();
        schemaExtensions.put("schema","urn:ietf:params:scim:schemas:extension:enterprise:2.0:User");
        schemaExtensions.put("required",true);
        JSONObject jSchema=new JSONObject();
        jSchema.put("schema", "urn:ietf:params:scim:schemas:sailpoint:1.0:User");
        jSchema.put("required", true);
        JSONArray schemaExtArray=new JSONArray();
        schemaExtArray.add(schemaExtensions);
        schemaExtArray.add(jSchema);
        type.put("schemaExtensions", schemaExtArray);
        type.put("id","User");
        resources.add(type);
        resourceTypes.put("Resources", resources);
        log.debug("Final ResourceType Object from Class "+resourceTypes.toString());
        return resourceTypes.toString();
    }
}
