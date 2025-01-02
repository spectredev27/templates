package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    // Jackson is set instead of Jakarta JSON Processing API through the property
    // resteasy.preferJacksonOverJsonB in src/main/resources/datasource.cli file.
    // Configure Jackson ObjectMapper.

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return objectMapper;
    }

}
