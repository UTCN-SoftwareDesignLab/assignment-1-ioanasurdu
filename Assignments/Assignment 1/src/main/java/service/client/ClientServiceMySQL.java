package service.client;

import model.Client;
import model.Role;
import model.User;
import model.builder.ClientBuilder;
import model.builder.UserBuilder;
import model.validation.ClientValidator;
import model.validation.Notification;
import model.validation.UserValidator;
import repository.client.ClientRepository;

import java.util.Collections;

public class ClientServiceMySQL implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceMySQL(ClientRepository clientRepository){

        this.clientRepository = clientRepository;
    }

    @Override
    public Notification<Boolean> addClient(String name, String icn, String pcn) {
        Client client = new ClientBuilder()
                .setName(name)
                .setICN(icn)
                .setPCN(pcn)
                .build();

        ClientValidator clientValidator = new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        Notification<Boolean> clientAddNotification = new Notification<>();

        if (!clientValid) {
            clientValidator.getErrors().forEach(clientAddNotification::addError);
            clientAddNotification.setResult(Boolean.FALSE);
        } else {
            clientAddNotification.setResult(clientRepository.addClient(client));
        }
        return clientAddNotification;
    }

    @Override
    public Notification<Boolean> updateClient(Long id, String name, String icn, String pcn) {
        Client client = new ClientBuilder()
                .setId(id)
                .setName(name)
                .setICN(icn)
                .setPCN(pcn)
                .build();

        ClientValidator clientValidator = new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        Notification<Boolean> clientUpdateNotification = new Notification<>();

        if (!clientValid) {
            clientValidator.getErrors().forEach(clientUpdateNotification::addError);
            clientUpdateNotification.setResult(Boolean.FALSE);
        } else {
            clientUpdateNotification.setResult(clientRepository.updateClient(client));
        }
        return clientUpdateNotification;
    }

    @Override
    public Notification<Boolean> viewClient(Long id, String name, String icn, String pcn) {
        Client client = new ClientBuilder()
                .setId(id)
                .setName(name)
                .setICN(icn)
                .setPCN(pcn)
                .build();

        ClientValidator clientValidator = new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        Notification<Boolean> clientUpdateNotification = new Notification<>();

        if (!clientValid) {
            clientValidator.getErrors().forEach(clientUpdateNotification::addError);
            clientUpdateNotification.setResult(Boolean.FALSE);
        } else {
            clientUpdateNotification.setResult(clientRepository.viewClient(client));
        }
        return clientUpdateNotification;
    }
}
