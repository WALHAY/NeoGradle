package com.walhay.neogradle.requests;

import com.ensarsarajcic.neovim.java.corerpc.message.RequestMessage;
import com.ensarsarajcic.neovim.java.handler.annotations.NeovimRequestListener;

public class NeovimRequestHandler {

    @NeovimRequestListener("neogradle")
    public Object handleRequest(RequestMessage message) {
        return "OK";
    }
}
