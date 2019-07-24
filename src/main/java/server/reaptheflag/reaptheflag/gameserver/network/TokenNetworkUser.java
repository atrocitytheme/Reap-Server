package server.reaptheflag.reaptheflag.gameserver.network;

import java.net.InetSocketAddress;

public class TokenNetworkUser extends NetworkUser{
    private String id;
    private String password;
    public TokenNetworkUser(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int commandType() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public String getIp() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public String getToken() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public int getRoom() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public int getPort() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public InetSocketAddress rawAddress() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public boolean isSpawned() {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public void setSpawned(boolean spawned) {
        throw new UnsupportedOperationException("operation not supported!");
    }
}
