package com.walhay.neogradle.requests;

import com.walhay.neogradle.api.INeovimRequest;

public class Status implements INeovimRequest {

    @Override
    public Object execute(String... args) {
        return "Status: OK";
    }

}
