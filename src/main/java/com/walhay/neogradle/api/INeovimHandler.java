package com.walhay.neogradle.api;

import com.ensarsarajcic.neovim.java.corerpc.message.RequestMessage;

public interface INeovimHandler {
    
    Object handleRequest(RequestMessage message);

}
