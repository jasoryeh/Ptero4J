package com.stanjg.ptero4j.actions;

import com.stanjg.ptero4j.PteroAdminAPI;
import com.stanjg.ptero4j.util.HTTPMethod;
import org.json.JSONObject;

public class GenericAction implements PteroVoidAction {

    private PteroAdminAPI api;
    private String endpoint;
    private HTTPMethod method;
    private JSONObject json;

    public GenericAction(PteroAdminAPI api, String endpoint, HTTPMethod method) {
        this(
                api,
                endpoint,
                method,
                new JSONObject()
        );
    }

    public GenericAction(PteroAdminAPI api, String endpoint, HTTPMethod method, JSONObject json) {
        this.api = api;
        this.endpoint = endpoint;
        this.method = method;
        this.json = json;
    }

    @Override
    public int execute() {
        return api.getGenericController().executeAction(this);
    }

    @Override
    public JSONObject getAsJSON() {
        return this.json;
    }

    @Override
    public String getEndpoint() {
        return this.endpoint;
    }

    @Override
    public HTTPMethod getMethod() {
        return this.method;
    }
}
