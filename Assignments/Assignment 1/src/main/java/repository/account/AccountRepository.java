package repository.account;

import model.Account;

public interface AccountRepository {
    public Boolean createAccount(Account account, Long clientId);

    public Boolean updateAccount(Account account, Long clientId);

    public Boolean deleteAccount(Account account);

    public Account getAccount(Long id);

    public boolean updateAmount(float amount, Long id);

}
