package com.walhay.neogradle.handlers;

import com.ensarsarajcic.neovim.java.corerpc.message.RequestMessage;
import com.walhay.neogradle.api.INeovimHandler;
import com.walhay.neogradle.api.INeovimRequest;
import com.walhay.neogradle.requests.RequestFactory;

@SuppressWarnings("unchecked")
public class GradleRequestHandler implements INeovimHandler {

    @com.ensarsarajcic.neovim.java.handler.annotations.NeovimRequestHandler("gradle")
    public Object handleRequest(RequestMessage message) {
        INeovimRequest request = RequestFactory.createRequest(message.getMethod(),(String[]) message.getArguments().toArray(String[]::new));
        return request.execute();
    }
}
