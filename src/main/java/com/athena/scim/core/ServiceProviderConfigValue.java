package com.athena.scim.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class ServiceProviderConfigValue {
    private static Logger log= LogManager.getLogger(ServiceProviderConfigValue.class);
    public static String getValue() {
        /*Dont Change the following until the next comment.
         * */
        log.debug("Starting the Service Provider Config Value");
        JSONObject servProviderConfigObject=new JSONObject();
        JSONArray schemaListArray=new JSONArray();
        schemaListArray.add("urn:ietf:params:scim:schemas:core:2.0:ServiceProviderConfig");
        servProviderConfigObject.put("schemas", schemaListArray);
        servProviderConfigObject.put("documentationUri", "https://tools.ietf.org/html/rfc7643");
        JSONObject patch=new JSONObject();
        patch.put("supported", false);
        servProviderConfigObject.put("patch", patch);
        JSONObject bulk=new JSONObject();
        bulk.put("supported", false);
        servProviderConfigObject.put("bulk",bulk);
        JSONObject sort=new JSONObject();
        sort.put("supported", false);
        servProviderConfigObject.put("sort",sort);
        JSONObject changePassword=new JSONObject();
        changePassword.put("supported", true);
        servProviderConfigObject.put("changePassword",changePassword);
        JSONObject etag=new JSONObject();
        etag.put("supported", false);
        servProviderConfigObject.put("etag",etag);
        JSONObject filter=new JSONObject();
        filter.put("supported", true);
        filter.put("maxResults", 200);
        servProviderConfigObject.put("filter",filter);
        //---> IF want change the modification from down below.
        /*The below JSON array contains two objects namely OAuth2 and the HTTP Basic
         * Currently the HTTP basic is set to the primary
         * Change/ Add other authentication methods based on need. add them to the authenticationSchemes array.
         * */
        JSONArray authenticationSchemes=new JSONArray();
        JSONObject oauth=new JSONObject();
        oauth.put("name", "OAuth Bearer Token");
        oauth.put("description", "Authentication scheme using the OAuth Bearer Token Standard");
        oauth.put("specUri", "http://www.rfc-editor.org/info/rfc6750");
        oauth.put("documentationUri", "http://www.rfc-editor.org/info/rfc6750");
        oauth.put("type", "oauthbearertoken");
        oauth.put("primary", true);
        authenticationSchemes.add(oauth);
        JSONObject basic=new JSONObject();
        basic.put("name", "HTTP Basic");
        basic.put("description", "Authentication scheme using the HTTP Basic Standard");
        basic.put("specUri", "http://www.rfc-editor.org/info/rfc2617");
        basic.put("documentationUri", "http://www.rfc-editor.org/info/rfc2617");
        basic.put("type", "httpbasic");
        authenticationSchemes.add(basic);
        servProviderConfigObject.put("authenticationSchemes", authenticationSchemes);
        JSONObject meta=new JSONObject();
        meta.put("location", "http://localhost:13080/scim/v1/ServiceProviderConfig");
        meta.put("resourceType", "ServiceProviderConfig");
        meta.put("created", "2010-01-23T04:56:22Z");
        meta.put("version", "1");
        meta.put("lastModified", "2011-05-13T04:42:34Z");
        servProviderConfigObject.put("meta", meta);
        log.debug("Returning the Value for Service Provider Config "+servProviderConfigObject.toString());
        return servProviderConfigObject.toString();
    }
}
