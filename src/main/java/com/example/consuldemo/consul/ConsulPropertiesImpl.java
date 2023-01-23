package com.example.consuldemo.consul;

import java.util.HashMap;
import java.util.Map;

public class ConsulPropertiesImpl implements ConsulProperties {

    private Map<String, String> dataProperties = new HashMap<>();

    public Map<String, String> getDataProperties() {
        return dataProperties;
    }

    @Override
    public String getDataByKey(String key) {
        if (dataProperties.containsKey(key))
            return dataProperties.get(key);
        return "";
    }
}
