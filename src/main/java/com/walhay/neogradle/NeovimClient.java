package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.corerpc.client.RpcClient;
import com.ensarsarajcic.neovim.java.handler.NeovimHandlerManager;
import com.ensarsarajcic.neovim.java.handler.annotations.NeovimRequestHandler;

public class NeovimClient {

    private static final NeovimClient NEOVIM_CLIENT = new NeovimClient();

    private RpcClient client;
    private NeovimHandlerManager handlerManager;

    public NeovimClient() {
        this.client = RpcClient.getDefaultAsyncInstance();

        this.handlerManager = new NeovimHandlerManager();

        this.handlerManager.registerNeovimHandler(this);
        this.handlerManager.attachToStream(this.client);
    }

    @NeovimRequestHandler("gradle")
    public Object handleRequest() {
        return "OK";
    }

    public RpcClient getClient() {
        return this.client;
    }

    public static NeovimClient getInstance() {
        return NEOVIM_CLIENT;
    }
}
