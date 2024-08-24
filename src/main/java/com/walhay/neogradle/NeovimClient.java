package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.corerpc.client.RpcClient;
import com.ensarsarajcic.neovim.java.handler.NeovimHandlerManager;
import com.walhay.neogradle.handlers.GradleRequestHandler;

public class NeovimClient {

    private static final NeovimClient NEOVIM_CLIENT = new NeovimClient();

    private final RpcClient client = RpcClient.getDefaultAsyncInstance();
    private final NeovimHandlerManager handler = new NeovimHandlerManager();
    private final GradleRequestHandler requestHandler = new GradleRequestHandler();

    public NeovimClient() {
        handler.attachToStream(this.client);
        handler.registerNeovimHandler(this.requestHandler);
    }

    public static NeovimHandlerManager getHandlerManager(){
        return NEOVIM_CLIENT.handler;
    }

    public static RpcClient getClient() {
        return NEOVIM_CLIENT.client;
    }

    public static NeovimClient getInstance() {
        return NEOVIM_CLIENT;
    }
}
