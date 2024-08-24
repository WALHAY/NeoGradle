package com.walhay.neogradle.requests;

import com.walhay.neogradle.api.INeovimRequest;

public class WrongRequest implements INeovimRequest {

    @Override
    public Object execute(String... args) {
        return "Wrong request";
    }
    
}
