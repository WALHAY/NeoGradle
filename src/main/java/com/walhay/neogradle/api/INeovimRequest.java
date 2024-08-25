package com.walhay.neogradle.api;

import com.ensarsarajcic.neovim.java.api.NeovimApi;

public interface INeovimRequest {

    Object execute(NeovimApi api, String... args);

}
