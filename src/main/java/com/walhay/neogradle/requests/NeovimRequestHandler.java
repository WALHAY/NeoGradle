package com.walhay.neogradle.requests;

import com.ensarsarajcic.neovim.java.corerpc.message.RequestMessage;
import com.ensarsarajcic.neovim.java.handler.annotations.NeovimRequestListener;
import com.ensarsarajcic.neovim.java.handler.errors.NeovimRequestException;

public class NeovimRequestHandler {

    @NeovimRequestListener("gradle")
    public Object handleRequest(RequestMessage message) throws NeovimRequestException {
        try {
            return "OK";
        } catch(Exception e) {
            throw new NeovimRequestException("Invalid Request");
        }
    }
}
