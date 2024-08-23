package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.api.NeovimApi;
import com.ensarsarajcic.neovim.java.api.NeovimApis;
import com.ensarsarajcic.neovim.java.corerpc.client.RpcClient;
import com.ensarsarajcic.neovim.java.corerpc.client.RpcConnection;
import com.ensarsarajcic.neovim.java.corerpc.client.StdIoRpcConnection;

public class NeoGradle {
    public static void main(String[] args) {
        RpcClient client = RpcClient.getDefaultAsyncInstance();
        RpcConnection connection = new StdIoRpcConnection();

        client.attach(connection);

        NeovimApi api = NeovimApis.getApiForConnection(connection);

        api.executeCommand("<cmd>lua print('hi')<cr>");
    }
}
