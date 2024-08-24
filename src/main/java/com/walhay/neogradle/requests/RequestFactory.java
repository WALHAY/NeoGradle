package com.walhay.neogradle.requests;

import java.util.Map;

import org.gradle.internal.impldep.com.google.common.collect.ImmutableMap;

import com.walhay.neogradle.api.INeovimRequest;

public class RequestFactory {

    public static Map<String, Class<? extends INeovimRequest>> REQUEST_MAP = ImmutableMap.of(
        "status", Status.class
    );
    
    public static INeovimRequest createRequest(String request, String... args) {
        Class<? extends INeovimRequest> clazz = REQUEST_MAP.getOrDefault(request, WrongRequest.class);
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch(Exception e) {}
        return null;
    }

}
