package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.corerpc.client.RpcClient;
import com.ensarsarajcic.neovim.java.corerpc.client.RpcConnection;
import com.ensarsarajcic.neovim.java.corerpc.client.StdIoRpcConnection;
import com.ensarsarajcic.neovim.java.handler.NeovimHandlerManager;
import com.walhay.neogradle.requests.NeovimRequestHandler;

public class NeoGradle {
    public static void main(String[] args) {
        RpcConnection connection = new StdIoRpcConnection();

        RpcClient client = RpcClient.getDefaultAsyncInstance();

        NeovimHandlerManager handler = new NeovimHandlerManager();
        handler.registerNeovimHandler(new NeovimRequestHandler());
        handler.attachToStream(client);

        client.attach(connection);
    }
}
