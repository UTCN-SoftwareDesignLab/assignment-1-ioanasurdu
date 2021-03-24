package service.client;

import model.User;
import model.validation.Notification;

public interface ClientService {
    public Notification<Boolean> addClient(String name, String icn, String pcn);
    public Notification<Boolean> updateClient(Long id, String name, String icn, String pcn);
    public Notification<Boolean> viewClient(Long id, String name, String icn, String pcn);
}
