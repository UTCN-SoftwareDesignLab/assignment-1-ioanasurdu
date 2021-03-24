package service.account;

import model.Account;
import model.builder.AccountBuilder;
import model.validation.AccountValidator;
import model.validation.Notification;
import repository.account.AccountRepository;
import repository.client.ClientRepository;


public class AccountServiceMySQL implements AccountService {
    private AccountRepository accountRepository;
    private ClientRepository clientRepository;

    public AccountServiceMySQL(AccountRepository accountRepository, ClientRepository clientRepository){

        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Notification<Boolean> createAccount(Long clientId, String cardNumber, String account_type, float amount) {
        Account account = new AccountBuilder()
                .setCardNumber(cardNumber)
                .setType(account_type)
                .setAmount(amount)
                .build();

        AccountValidator accountValidator = new AccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> accountAddNotification = new Notification<>();

        if (!accountValid) {
            accountValidator.getErrors().forEach(accountAddNotification::addError);
            accountAddNotification.setResult(Boolean.FALSE);
        } else {
            accountAddNotification.setResult(accountRepository.createAccount(account, clientId));
        }
        return accountAddNotification;
    }

    @Override
    public Notification<Boolean> updateAccount(Long clientId, String cardNumber, String account_type, float amount) {
        Account account = new AccountBuilder()
                .setCardNumber(cardNumber)
                .setType(account_type)
                .setAmount(amount)
                .build();

        AccountValidator accountValidator = new AccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> accountAddNotification = new Notification<>();

        if (!accountValid) {
            accountValidator.getErrors().forEach(accountAddNotification::addError);
            accountAddNotification.setResult(Boolean.FALSE);
        } else {
            accountAddNotification.setResult(accountRepository.updateAccount(account, clientId));
        }
        return accountAddNotification;
    }

    @Override
    public Notification<Boolean> deleteAccount(String cardNumber, String account_type, float amount) {
        Account account = new AccountBuilder()
                .setCardNumber(cardNumber)
                .setType(account_type)
                .setAmount(amount)
                .build();

        AccountValidator accountValidator = new AccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> accountAddNotification = new Notification<>();

        if (!accountValid) {
            accountValidator.getErrors().forEach(accountAddNotification::addError);
            accountAddNotification.setResult(Boolean.FALSE);
        } else {
            accountAddNotification.setResult(accountRepository.deleteAccount(account));
        }
        return accountAddNotification;
    }

    @Override
    public int transfer(Long acc1, Long acc2, float amount) {

        Account a1 = accountRepository.getAccount(acc1);
        Account a2 = accountRepository.getAccount(acc2);

        if (amount > a1.getAmount()) {
            return 0;
        } else {
            accountRepository.updateAmount(a1.getAmount() - amount, acc1);
            accountRepository.updateAmount(a2.getAmount() + amount, acc2);
            return 1;
        }
    }

    @Override
    public int processBill(Long acc, float amount) {
        Account a1 = accountRepository.getAccount(acc);

        if (amount > a1.getAmount()) {
            return 0;
        } else {
            accountRepository.updateAmount(a1.getAmount() - amount, acc);
            return 1;
        }
    }
}
