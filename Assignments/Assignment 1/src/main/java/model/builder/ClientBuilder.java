package model.builder;

import model.Client;

public class ClientBuilder {

    private Client client;

    public ClientBuilder() { client = new Client(); }

    public ClientBuilder setId(Long id) {
        client.setId(id);
        return this;
    }

    public ClientBuilder setName(String name) {
        client.setName(name);
        return this;
    }

    public ClientBuilder setICN(String icn) {
        client.setICN(icn);
        return this;
    }

    public ClientBuilder setPCN(String pcn) {
        client.setPCN(pcn);
        return this;
    }

    public Client build() { return this.client; }
}
