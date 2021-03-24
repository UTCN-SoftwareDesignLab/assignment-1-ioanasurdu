package repository.client;

import database.Bootstraper;
import model.Client;

public interface ClientRepository {
    public Boolean addClient(Client client);

    public Boolean updateClient(Client client);

    public Boolean viewClient(Client client);
}
