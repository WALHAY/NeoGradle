package com.walhay.neogradle;

import com.ensarsarajcic.neovim.java.api.NeovimApi;
import com.ensarsarajcic.neovim.java.api.NeovimApis;
import com.ensarsarajcic.neovim.java.corerpc.client.RpcConnection;

public class NeovimApiWrapper {

    private final NeovimApi api;

    public NeovimApiWrapper(RpcConnection connection) {
        this.api = NeovimApis.getApiForConnection(connection);
    }

    public NeovimApiWrapper(NeovimApi api) {
        this.api = api;
    }

    public final NeovimApi getApi() {
        return this.api;
    }

}
