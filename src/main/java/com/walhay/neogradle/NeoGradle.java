package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.corerpc.client.RpcConnection;
import com.ensarsarajcic.neovim.java.corerpc.client.StdIoRpcConnection;

public class NeoGradle {
    public static void main(String[] args) {
        RpcConnection connection = new StdIoRpcConnection();
        NeovimClient.getInstance().getClient().attach(connection);
    }
}
