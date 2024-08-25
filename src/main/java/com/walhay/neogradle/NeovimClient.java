package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.corerpc.client.RpcClient;
import com.ensarsarajcic.neovim.java.corerpc.client.RpcConnection;
import com.ensarsarajcic.neovim.java.handler.NeovimHandlerManager;
import com.walhay.neogradle.handlers.GradleRequestHandler;

public class NeovimClient {

    private static final NeovimClient NEOVIM_CLIENT = new NeovimClient();

    private final RpcClient client = RpcClient.getDefaultAsyncInstance();
    private final NeovimHandlerManager handler = new NeovimHandlerManager();
    private final GradleRequestHandler requestHandler = new GradleRequestHandler();
    private NeovimApiWrapper apiWrapper;

    public NeovimClient() {
        handler.attachToStream(this.client);
        handler.registerNeovimHandler(this.requestHandler);
    }

    public static void attachConnection(RpcConnection connection) {
        NEOVIM_CLIENT.apiWrapper = new NeovimApiWrapper(connection);
        NEOVIM_CLIENT.client.attach(connection);
    }

    public static NeovimClient getInstance() {
        return NEOVIM_CLIENT;
    }

    public static NeovimApiWrapper getApiWrapper() {
        return NEOVIM_CLIENT.apiWrapper;
    }

    public static NeovimHandlerManager getHandlerManager() {
        return NEOVIM_CLIENT.handler;
    }
}
