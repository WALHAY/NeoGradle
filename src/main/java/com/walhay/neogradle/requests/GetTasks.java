package com.walhay.neogradle.requests;

import com.ensarsarajcic.neovim.java.api.NeovimApi;
import com.walhay.neogradle.api.INeovimRequest;

public class GetTasks implements INeovimRequest {

    @Override
    public Object execute(NeovimApi api, String... args) {
        return "GetTasks";
    }

}
