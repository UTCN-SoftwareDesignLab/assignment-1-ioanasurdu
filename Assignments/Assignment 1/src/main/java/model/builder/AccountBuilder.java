package model.builder;

import model.Account;

public class AccountBuilder {
    private Account account;

    public AccountBuilder() {
        account = new Account();
    }

    public AccountBuilder setId(Long id) {
        account.setId(id);
        return this;
    }

    public AccountBuilder setCardNumber(String cardNumber) {
        account.setCardNumber(cardNumber);
        return this;
    }

    public AccountBuilder setType(String type) {
        account.setType(type);
        return this;
    }

    public AccountBuilder setAmount(float amount) {
        account.setAmount(amount);
        return this;
    }

    public Account build() { return this.account; }

}
