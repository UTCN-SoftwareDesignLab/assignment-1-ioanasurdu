package service.account;

import model.User;
import model.validation.Notification;

import java.time.LocalDate;
import java.util.Date;

public interface AccountService {
    public Notification<Boolean> createAccount(Long clientId, String cardNumber, String account_type, float amount);

    public Notification<Boolean> updateAccount(Long clientId, String cardNumber, String account_type, float amount);

    public Notification<Boolean> deleteAccount(String cardNumber, String account_type, float amount);

    public int transfer(Long acc1, Long acc2, float amount);

    public int processBill(Long acc, float amount);
}
